/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import Kayttoliittyma.Valikot.Kuuntelijat.Paivitin;
import Kayttoliittyma.Valikot.Kuuntelijat.Pysaytin;
import Sovelluslogiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Raskas ja sotkuinen luokka, joka näyttää pelin etenemisen käyttäjälle ja
 * tarjoaa toiminnallisuuden operoida sitä.
 *
 * @author Kasperi
 */
public class PeliRuutu implements Runnable {

    JFrame laatikko;
    JFrame aloitus;
    Peli peli;
    int vuoro = 0;
    JLabel aika;
    JLabel vuorotieto;
    Paivitin paivitin;
    IlmoitusLoota aikaLoppui;
    Timer timer;

    public PeliRuutu(Peli peli) {
        this.peli = peli;
    }

    /**
     * Alustaa ikkunat sekä ajan digitaaliesityksen päivittämistä varten
     * tarvittavat työkalut.
     */
    @Override
    public void run() {
        laatikko = new JFrame("Peli ruutu");
        laatikko.setPreferredSize(new Dimension(400, 300));
        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(false);

        paivitin = new Paivitin(aika, peli);
        timer = new Timer(1000, paivitin);

        aloitus = new JFrame("Peli alkaa!");
        aloitus.setPreferredSize(new Dimension(300, 200));
        luoAloitus(aloitus.getContentPane());

        aloitus.pack();
        aloitus.setVisible(true);

        aikaLoppui = new IlmoitusLoota("Peliaika loppui!");
        aikaLoppui.run();
    }

    /**
     * Alustaa ilmoitusikkunan, joka aloittaa pelin painikkeella.
     */
    private void luoAloitus(Container loota) {
        loota.setLayout(new GridLayout(2, 1));

        loota.add(new JLabel("Pelin aloittaa " + peli.getPelaaja(peli.vuorossa).nimi));
        JButton ok = new JButton("OK");

        ActionListener okPainike = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aloitus.setVisible(false);
                laatikko.setVisible(true);
                timer.start();
            }
        };
        ok.addActionListener(okPainike);
        loota.add(ok);
    }

    /**
     * Alustaa peli ruudun sisällön sekä muutaman napin toiminnallisuuden.
     */
    private void luoKomponentit(Container loota) {

        aika = new JLabel(peli.ajastin.toString());
        vuorotieto = new JLabel(((peli.pelattujaVuoroja + peli.pelaajat.size()) / peli.pelaajat.size())
                + ". kierros, VUOROSSA: " + peli.getPelaaja(peli.vuorossa).nimi
                + " SEURAAVAKSI: " + peli.getSeuraavaPelaaja().nimi);

        JButton seuraava = new JButton("Aloita seuraavan pelaajan vuoro");
        seuraava.addActionListener(seuraavaVuoroNappi);

        JButton stop = new JButton("ON/OFF");
        ActionListener stopperi = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                } else {
                    timer.start();
                }
            }
        };
        stop.addActionListener(stopperi);

        JButton lopeta = new JButton("Lopeta peli");
        ActionListener lopetaPeli = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loppuTuloksiin();
            }
        };
        lopeta.addActionListener(lopetaPeli);

        loota.add(seuraava, BorderLayout.EAST);
        loota.add(aika, BorderLayout.CENTER);
        loota.add(vuorotieto, BorderLayout.NORTH);
        loota.add(stop, BorderLayout.WEST);
        loota.add(lopeta, BorderLayout.SOUTH);
    }
    /**
     * Kuuntelija sisältää toiminnallisuuden vuoron siirtymistä varten sekä
     * vuorojen välissä tapahtuvat muutokset pelissä.
     */
    ActionListener seuraavaVuoroNappi = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            peli.pelattujaVuoroja++;
            peli.vuoroSiirtyy();
            if (peli.pelattujaVuoroja == peli.vuoroRaja * peli.pelaajat.size()) {
                loppuTuloksiin();
            } else if (peli.pelattujaVuoroja == peli.vuoroRaja * peli.pelaajat.size() - 1) {
                vuorotieto.setText(((peli.pelattujaVuoroja + peli.pelaajat.size()) / peli.pelaajat.size())
                        + ". kierros, VUOROSSA: " + peli.getPelaaja(peli.vuorossa).nimi
                        + " VIIMEINEN VUORO!");
            } else {
                setVuorotieto();
            }

            peli.ajastin.alustaAjastin();
            aika.setText(peli.ajastin.toString());
            if (!timer.isRunning()) {
                timer.start();
            }
            if (peli.aikaLoppui) {
                loppuTuloksiin();
                aikaLoppui.setVisible(true);
            }
        }

    };

    /**
     * Asettaa vuorotieto-tekstille tiedot nykyisestä vuorosta.
     */
    private void setVuorotieto() {
        vuorotieto.setText(((peli.pelattujaVuoroja + peli.pelaajat.size()) / peli.pelaajat.size())
                + ". kierros, VUOROSSA: " + peli.getPelaaja(peli.vuorossa).nimi
                + " SEURAAVAKSI: " + peli.getSeuraavaPelaaja().nimi);
    }

    /**
     * Navigoi käyttäjän pois peli ruudusta lopputulosikkunaan.
     */
    public void loppuTuloksiin() {
        laatikko.setVisible(false);
        Lopputulokset lopputulokset = new Lopputulokset(peli);
        lopputulokset.run();
    }
}
