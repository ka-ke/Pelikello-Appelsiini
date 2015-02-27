/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Domain.Aaniefektit.Aani;
import Kayttoliittyma.GUIOhjain;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.WindowConstants;

/**
 * Ensimmäinen ikkuna, joka avautuu ohjelman käynnistyessä. Navigoi joko uuteen
 * peliin tai pelkkään ajanottoon.
 *
 * @author Kasperi
 */
public class KaynnistysValikko implements Runnable {

    private JFrame laatikko;
    private Aani aani;

    @Override
    public void run() {

        laatikko = new JFrame("Pelikello-Appelsiini");
        laatikko.setPreferredSize(new Dimension(300, 400));

        laatikko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    /**
     * Luo ikkunan sisällön ja asettaa painikkeet navigoimaan käyttäjän uusiin
     * ikkunoihin.
     */
    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(2, 1));

        JButton aloita = new JButton("Aloita peli");
        JButton aikaa = new JButton("Ota aikaa");

        aloita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIOhjain.alustaPeli();
            }
        });

        aikaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIOhjain.aloitaAjanotto();
            }
        });

        loota.add(aloita);
        loota.add(aikaa);
    }

    public void piilota(boolean b) {
        laatikko.setVisible(b);
    }
}
