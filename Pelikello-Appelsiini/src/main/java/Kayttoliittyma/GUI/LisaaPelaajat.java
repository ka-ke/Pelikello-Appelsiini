/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Domain.Ajastin;
import Domain.Pelaaja;
import Kayttoliittyma.GUI.Kuuntelijat.PelaajanLisays;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Asetusten jälkeen seuraava ikkuna, jonka avulla lisätään valittu määrä
 * pelaajia.
 *
 * @author Kasperi
 */
public class LisaaPelaajat implements Runnable {

    public JFrame laatikko;
    public ArrayList<Pelaaja> pelaajat;
    public Ajastin ajastin;
    public Ajastin aikaRaja;
    public int vuoroja;
    public int pelaajia;
    public int lisattava = 1;
    public IlmoitusLoota samaNimi;
    public IlmoitusLoota huonoNimi;
    public TextField nimiText;
    private JLabel pelaajanNimi;

    /**
     * Parametreina annetaan pelin luomiseen tarvittavat tiedot asetusvalikosta.
     *
     * @param pelaajat Tyhjä lista pelaajista.
     * @param ajastin Asetuksissa luotu vuoroaikaraja-ajastin.
     * @param vuoroja Asetuksissa määrätty vuororaja.
     * @param aikaRaja Asetuksissa luotu peliaikaraja-ajastin.
     * @param pelaajia Asetuksissa määrätty pelaajamäärä.
     */
    public LisaaPelaajat(ArrayList<Pelaaja> pelaajat, Ajastin ajastin, int vuoroja, Ajastin aikaRaja, int pelaajia) {
        this.pelaajat = pelaajat;
        this.ajastin = ajastin;
        this.vuoroja = vuoroja;
        this.pelaajia = pelaajia;
        this.aikaRaja = aikaRaja;
    }

    @Override
    public void run() {

        laatikko = new JFrame("Lisää pelaaja");
        laatikko.setPreferredSize(new Dimension(200, 200));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(true);

        samaNimi = new IlmoitusLoota("Et voi valita samaa nimeä uudestaan");
        huonoNimi = new IlmoitusLoota("Laitapas joku kunnon nimi");
        samaNimi.run();
        huonoNimi.run();
    }

    private void luoKomponentit(final Container loota) {

        loota.setLayout(new GridLayout(2, 2, 5, 5));

        pelaajanNimi = new JLabel("Lisättävän pelaajan nimi:");
        loota.add(pelaajanNimi);
        nimiText = new TextField("nimi");
        loota.add(nimiText);
        JButton lisaa = new JButton("Lisää");
        loota.add(lisaa);

        lisaa.addActionListener(new PelaajanLisays(this));
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
