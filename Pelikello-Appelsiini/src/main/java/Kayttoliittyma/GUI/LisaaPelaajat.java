/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Domain.Ajastin;
import Domain.Pelaaja;
import Domain.Peli;
import Kayttoliittyma.GUI.Kuuntelijat.PelaajanLisays;
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
 * Asetusten jälkeen seuraava ikkuna, jonka avulla lisätään valittu määrä
 * pelaajia.
 *
 * @author Kasperi
 */
public class LisaaPelaajat implements Runnable {

    public JFrame laatikko;
    public List<Pelaaja> pelaajat;
    public Ajastin ajastin;
    public Ajastin aikaRaja;
    public int vuoroja;
    public int pelaajia;
    public int lisattava = 1;
    public IlmoitusLoota samaNimi;
    public IlmoitusLoota huonoNimi;
    public TextField nimiText;
    JLabel pelaajanNimi;

    /**
     * Parametreina annetaan pelin luomiseen tarvittavat tiedot asetusvalikosta.
     */
    public LisaaPelaajat(List<Pelaaja> pelaajat, Ajastin ajastin, int vuoroja, Ajastin aikaRaja, int pelaajia) {
        this.pelaajat = pelaajat;
        this.ajastin = ajastin;
        this.vuoroja = vuoroja;
        this.pelaajia = pelaajia;
        this.aikaRaja = aikaRaja;
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

    /**
     * Asetetaan ikkunan sisältö ja toiminnallisuus lisää-painikkeelle.
     */
    private void luoKomponentit(final Container loota) {

        loota.setLayout(new GridLayout(2, 2));

        pelaajanNimi = new JLabel("Lisättävän pelaajan nimi:");
        loota.add(pelaajanNimi);
        nimiText = new TextField("nimi");
        loota.add(nimiText);
        JButton lisaa = new JButton("Lisää");
        loota.add(lisaa);

        lisaa.addActionListener(new PelaajanLisays(this));
    }
    
    public void piilota(boolean b) {
        laatikko.setVisible(b);
    }
}
