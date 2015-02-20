/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import Sovelluslogiikka.Ajastin;
import Sovelluslogiikka.Pelaaja;
import Sovelluslogiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javafx.scene.control.CheckBox;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.WindowConstants;

/**
 * Valikko, jonka avulla luodaan eri tyyppinen peli käyttäjän valintojen
 * perusteella.
 *
 * @author Kasperi
 */
public class PelinAsetukset implements Runnable {

    private JFrame laatikko;
    IlmoitusLoota virhe;
    TextField pelaajiaText;
    TextField vuorojaText;
    TextField sek;
    TextField min;
    TextField sekAika;
    TextField minAika;

    @Override
    public void run() {

        laatikko = new JFrame("Pelin asetukset");
        laatikko.setPreferredSize(new Dimension(1000, 600));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);

        virhe = new IlmoitusLoota("Et syöttänyt sopivia arvoja");
        virhe.run();
    }

    /**
     * Luodaan komponentit sekä lisätään jatka-painikkeelle toiminnallisuus.
     */
    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(5, 3));

        JLabel paljonkoAikaa = new JLabel("Paljonko aikaa per vuoro? Vähintään 1 sekunti ja enintään 59:59");
        min = new TextField("00");
        sek = new TextField("10");
        JLabel montakoPelaajaa = new JLabel("Montako pelaajaa? Minimi on yksi");
        pelaajiaText = new TextField("2");
        JLabel asetetaankoAika = new JLabel("Asetetaanko pelille aikarajoitinta? Jätä nollat mikäli ei");
        minAika = new TextField("00");
        sekAika = new TextField("00");
        JLabel asetataankoVuoro = new JLabel("Asetetaanko pelille kierrosrajoitinta? Jätä nolla mikäli ei");
        vuorojaText = new TextField("0");
        JButton jatka = new JButton("Jatka");
        JLabel tyhja1 = new JLabel("");
        JLabel tyhja2 = new JLabel("");

        jatka.addActionListener(pelaajanLisaykseen);

        loota.add(paljonkoAikaa);
        loota.add(min);
        loota.add(sek);
        loota.add(montakoPelaajaa);
        loota.add(pelaajiaText);
        loota.add(tyhja1);
        loota.add(asetetaankoAika);
        loota.add(minAika);
        loota.add(sekAika);
        loota.add(asetataankoVuoro);
        loota.add(vuorojaText);
        loota.add(tyhja2);
        loota.add(jatka);
    }
    /**
     * Tallentaa valikkoon syötetyt asetukset ja navigoi seuraavaan valikkoon.
     * Luo virheviestilaatikoita, mikäli syöte ei ole oikeanlaista.
     */
    ActionListener pelaajanLisaykseen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int vuoroja;
            int pelaajia;

            try {
                vuoroja = Integer.parseInt(vuorojaText.getText());
                pelaajia = Integer.parseInt(pelaajiaText.getText());
            } catch (Exception ex) {
                virhe.setVisible(true);
                return;
            }
            if (pelaajia < 1) {
                virhe.setVisible(true);
                return;
            }
            if (vuoroja < 0) {
                virhe.setVisible(true);
                return;
            }

            Ajastin ajastin;
            Ajastin aikaRaja;
            try {
                ajastin = new Ajastin(Integer.parseInt(min.getText()), Integer.parseInt(sek.getText()));
                aikaRaja = new Ajastin(Integer.parseInt(minAika.getText()),
                        Integer.parseInt(sekAika.getText()));
            } catch (Exception ex) {
                virhe.setVisible(true);
                return;
            }
            if (ajastin.toString().equals("00:00")) {
                virhe.setVisible(true);
                return;
            }

            List<Pelaaja> pelaajat = new ArrayList();
            LisaaPelaajat lisaaPelaajat = new LisaaPelaajat(pelaajat, ajastin, vuoroja, aikaRaja,
                    pelaajia);

            laatikko.setVisible(false);
            lisaaPelaajat.run();
        }
    };
}
