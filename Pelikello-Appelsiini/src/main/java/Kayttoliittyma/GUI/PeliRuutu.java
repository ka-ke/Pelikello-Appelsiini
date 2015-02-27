/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Kayttoliittyma.GUI.Kuuntelijat.PelikellonPaivitin;
import Kayttoliittyma.GUI.Kuuntelijat.Pysaytin;
import Domain.Peli;
import Kayttoliittyma.GUI.Kuuntelijat.SeuraavaVuoro;
import Kayttoliittyma.GUIOhjain;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Ikkuna, joka näyttää pelin etenemisen käyttäjälle ja painikkeet sen
 * ohjaamiseen.
 *
 * @author Kasperi
 */
public class PeliRuutu implements Runnable {

    private JFrame laatikko;
    private JFrame aloitus;
    private Peli peli;
    private int vuoro = 0;
    /**
     * Jäljellä oleva vuoroaika.
     */
    public JLabel aika;
    /**
     * Tietoa kierroksesta, vuorosta ja seuraavasta vuorosta.
     */
    public JLabel vuorotieto;
    /**
     * Ilmoitusviesti, mikäli peliaika loppuu.
     */
    public IlmoitusLoota aikaLoppui;
    /**
     * Kutsuu aikatiedon päivitintä kerran sekunnissa.
     */
    public Timer laukaisija;

    /**
     *
     * @param peli Peli, jonka asetuksin aikaa otetaan.
     */
    public PeliRuutu(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        laatikko = new JFrame("Ajastettava peli");
        laatikko.setPreferredSize(new Dimension(500, 500));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(false);

        aloitus = new JFrame("Peli alkaa!");
        aloitus.setPreferredSize(new Dimension(300, 200));
        luoAloitusLaatikko(aloitus.getContentPane());

        aloitus.pack();
        aloitus.setVisible(true);

        aikaLoppui = new IlmoitusLoota("Peliaika loppui!");
        aikaLoppui.run();
    }

    private void luoAloitusLaatikko(Container loota) {
        loota.setLayout(new GridLayout(2, 1));

        loota.add(new JLabel("Pelin aloittaa " + peli.getPelaaja(peli.vuorossa).nimi, JLabel.CENTER));
        JButton ok = new JButton("OK");

        ActionListener okPainike = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aloitus.setVisible(false);
                nayta(true);
                laukaisija.start();
            }
        };
        ok.addActionListener(okPainike);
        loota.add(ok);
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(3, 1));
        JPanel ylaosa = new JPanel();
        JPanel alaosa = new JPanel();
        ylaosa.setLayout(new GridLayout(1, 1));
        alaosa.setLayout(new GridLayout(3, 1));

        aika = new JLabel(peli.ajastin.toString(), JLabel.CENTER);
        aika.setFont(new Font("Serif", Font.BOLD, 100));
        vuorotieto = new JLabel("", JLabel.CENTER);
        vuorotieto.setFont(new Font("Serif", Font.PLAIN, 15));
        setVuorotieto();

        PelikellonPaivitin paivitin = new PelikellonPaivitin(aika, peli);
        laukaisija = new Timer(1000, paivitin);

        JButton seuraava = new JButton("Aloita seuraavan pelaajan vuoro");
        seuraava.addActionListener(new SeuraavaVuoro(this, peli));

        JButton stop = new JButton("Pysäytä/jatka");
        stop.addActionListener(new Pysaytin(laukaisija));

        JButton lopeta = new JButton("Lopeta peli");
        ActionListener lopetaPeli = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loppuTuloksiin();
            }
        };
        lopeta.addActionListener(lopetaPeli);

        ylaosa.add(aika);
        alaosa.add(seuraava);
        alaosa.add(stop);
        alaosa.add(lopeta);

        loota.add(vuorotieto);
        loota.add(ylaosa);
        loota.add(alaosa);
    }

    /**
     * Päivittää vuorotietotekstin.
     */
    public void setVuorotieto() {
        vuorotieto.setText(((peli.pelattujaVuoroja + peli.pelaajat.size()) / peli.pelaajat.size())
                + ". kierros, VUOROSSA: " + peli.getPelaaja(peli.vuorossa).nimi
                + " SEURAAVAKSI: " + peli.getSeuraavaPelaaja().nimi);
    }

    /**
     * Pysäyttää ajankulun ja kutsuu GUIOhjainta lopettamaan pelin.
     */
    public void loppuTuloksiin() {
        laukaisija.stop();
        GUIOhjain.lopetaPeli(peli);
    }

    /**
     * GUIOhjaimen käyttämä luokka Ajanotto-ikkunan näkyvyyden määrittämiseksi.
     *
     * @param nakyy true jos näkyy, false mikäli ei.
     */
    public void nayta(boolean nakyy) {
        laatikko.setVisible(nakyy);
    }
}
