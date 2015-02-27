/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Kayttoliittyma.GUI.Kuuntelijat.AsetustenTallennus;
import java.awt.*;
import javax.swing.*;

/**
 * Valikko, johon käyttäjä syöttää arvot ajastettavan pelin luomista varten.
 *
 * @author Kasperi
 */
public class PelinAsetukset implements Runnable {

    private JFrame laatikko;
    /**
     * Ikkuna, joka avautuu, mikäli jokin syöte on jatkaessa virheellinen.
     */
    public IlmoitusLoota virhe;
    /**
     * Käyttäjä syöttää pelaajien lukumäärän.
     */
    public TextField pelaajiaText;
    /**
     * Käyttäjä syöttää halutun vuororajoituksen.
     */
    public TextField vuorojaText;
    /**
     * Käyttäjä syöttää vuoroajan sekuntit.
     */
    public TextField sek;
    /**
     * Käyttäjä syöttää vuoroajan minuutit.
     */
    public TextField min;
    /**
     * Käyttäjä syöttää peliajan sekuntit.
     */
    public TextField sekAika;
    /**
     * Käyttäjä syöttää peliajan minuutit.
     */
    public TextField minAika;

    @Override
    public void run() {

        laatikko = new JFrame("Pelin asetukset");
        laatikko.setPreferredSize(new Dimension(500, 500));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(true);

        virhe = new IlmoitusLoota("Et syöttänyt sopivia arvoja");
        virhe.run();
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(1, 2));
        JPanel vasen = new JPanel();
        JPanel oikea = new JPanel();
        vasen.setLayout(new GridLayout(10, 1, 5, 5));
        oikea.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel paljonkoAikaa = new JLabel("Paljonko aikaa per vuoro?");
        JLabel paljonkoAikaaRajat = new JLabel("(00:01-59:59)");
        JLabel montakoPelaajaa = new JLabel("Montako pelaajaa?");
        JLabel montakoPelaajaaRajat = new JLabel("(1-10)");
        JLabel asetetaankoAika = new JLabel("Asetetaanko pelille aikarajoitinta?");
        JLabel asetetaankoAikaRajat = new JLabel("Jätä nollat mikäli ei. (00:01-59:59)");
        JLabel asetataankoVuoro = new JLabel("Asetetaanko pelille kierrosrajoitinta?");
        JLabel asetetaankoVuoroRajat = new JLabel("Jätä nolla mikäli ei. (1-100)");
        min = new TextField("00");
        sek = new TextField("00");
        pelaajiaText = new TextField("0");
        minAika = new TextField("00");
        sekAika = new TextField("00");
        vuorojaText = new TextField("0");

        JButton jatka = new JButton("Jatka pelaajienlisäykseen");
        jatka.setSize(50, 50);
        jatka.addActionListener(new AsetustenTallennus(this));

        vasen.add(paljonkoAikaa);
        vasen.add(paljonkoAikaaRajat);
        vasen.add(montakoPelaajaa);
        vasen.add(montakoPelaajaaRajat);
        vasen.add(asetetaankoAika);
        vasen.add(asetetaankoAikaRajat);
        vasen.add(asetataankoVuoro);
        vasen.add(asetetaankoVuoroRajat);
        vasen.add(jatka);

        oikea.add(min);
        oikea.add(sek);
        oikea.add(pelaajiaText);
        oikea.add(new JLabel(""));
        oikea.add(minAika);
        oikea.add(sekAika);
        oikea.add(vuorojaText);
        oikea.add(new JLabel(""));

        loota.add(vasen);
        loota.add(oikea);
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
