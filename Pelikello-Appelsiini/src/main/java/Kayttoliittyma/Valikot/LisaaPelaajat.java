/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import Sovelluslogiikka.Ajastin;
import Sovelluslogiikka.Pelaaja;
import Sovelluslogiikka.Peli;
import java.util.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.CheckBox;
import javax.swing.*;
import javax.swing.WindowConstants;

/**
 *
 * @author Kasperi
 */
public class LisaaPelaajat implements Runnable {

    private JFrame laatikko;
    List<Pelaaja> pelaajat;
    Ajastin ajastin;
    int vuoroja;
    int pelaajia;
    int lisattava = 1;
    IlmoitusLoota samaNimi;
    IlmoitusLoota huonoNimi;
    TextField nimiText;
    JLabel pelaajanNimi;

    public LisaaPelaajat(List<Pelaaja> pelaajat, Ajastin ajastin, int vuoroja, int pelaajia) {
        this.pelaajat = pelaajat;
        this.ajastin = ajastin;
        this.vuoroja = vuoroja;
        this.pelaajia = pelaajia;
    }

    @Override
    public void run() {

        laatikko = new JFrame("Lisää pelaaja");
        laatikko.setPreferredSize(new Dimension(300, 200));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);

        samaNimi = new IlmoitusLoota("Et voi valita samaa nimeä uudestaan");
        huonoNimi = new IlmoitusLoota("Laitapas joku kunnon nimi");
        samaNimi.run();
        huonoNimi.run();
    }

    private void luoKomponentit(final Container loota) {

        loota.setLayout(new GridLayout(2, 2));

        pelaajanNimi = new JLabel("Lisättävän pelaajan nimi:");
        loota.add(pelaajanNimi);
        nimiText = new TextField("nimi");
        loota.add(nimiText);
        JButton lisaa = new JButton("Lisää");
        loota.add(lisaa);

        lisaa.addActionListener(lisaaPelaaja);
    }

    ActionListener lisaaPelaaja = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nimi = nimiText.getText().trim();

            if (nimi.isEmpty()) {
                huonoNimi.setVisible(true);
                return;
            }

            for (Pelaaja p : pelaajat) {
                if (p.nimi.equals(nimi)) {
                    samaNimi.setVisible(true);
                    return;
                }
            }

            pelaajat.add(new Pelaaja(nimi, lisattava));
            nimiText.setText("");
            lisattava++;

            if (lisattava > pelaajia) {
                laatikko.setVisible(false);
                Peliruutu peliruutu = new Peliruutu(new Peli(ajastin, pelaajat, vuoroja));
                peliruutu.run();
            }
        }
    };
}
