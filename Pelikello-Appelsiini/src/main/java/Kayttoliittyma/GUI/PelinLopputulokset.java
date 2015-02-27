/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Domain.Pelaaja;
import Domain.Peli;
import Kayttoliittyma.GUI.Kuuntelijat.IkkunanSulkija;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Näyttää paljonko kukin pelaaja käytti peliaikaa ja kiittää pelistä.
 *
 * @author Kasperi
 */
public class PelinLopputulokset implements Runnable {

    private Peli peli;
    private JFrame laatikko;

    /**
     * @param peli Saa tiedot pelatusta pelistä.
     */
    public PelinLopputulokset(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        laatikko = new JFrame("Kulutettu peliaika");
        laatikko.setPreferredSize(new Dimension(500, 500));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(true);
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(peli.pelaajat.size() + 1, 1));

        for (int i = 0; i < peli.pelaajat.size(); i++) {
            Pelaaja pelaaja = peli.getPelaaja(i);
            loota.add(new JLabel(pelaaja.nimi + ": " + pelaaja.getPeliAika(), JLabel.CENTER));
        }

        JButton lopeta = new JButton("Kiitos pelistä, palaa käynnistysvalikkoon");
        lopeta.addActionListener(new IkkunanSulkija(laatikko));
        loota.add(lopeta);
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
