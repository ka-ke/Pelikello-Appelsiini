/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Kayttoliittyma.GUI.Kuuntelijat.AsetustenTallennus;
import Domain.Ajastin;
import Domain.Pelaaja;
import Domain.Peli;
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

    public JFrame laatikko;
    public IlmoitusLoota virhe;
    public TextField pelaajiaText;
    public TextField vuorojaText;
    public TextField sek;
    public TextField min;
    public TextField sekAika;
    public TextField minAika;

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

        jatka.addActionListener(new AsetustenTallennus(this));

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
    
    public void piilota(boolean b) {
        laatikko.setVisible(b);
    }
}
