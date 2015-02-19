/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.WindowConstants;

/**
 *
 * @author Kasperi
 */
public class Kaynnistysvalikko implements Runnable {

    private JFrame laatikko;

    @Override
    public void run() {
        laatikko = new JFrame("Pelikello-Appelsiini");
        laatikko.setPreferredSize(new Dimension(300, 400));

        laatikko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(2, 1));

        JButton aloita = new JButton("Aloita peli");
        ActionListener pelivalikkoon = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PelinAsetukset peli = new PelinAsetukset();
                peli.run();
            }
        };

        aloita.addActionListener(pelivalikkoon);
        JButton aikaa = new JButton("Ota aikaa");

        loota.add(aloita);
        loota.add(aikaa);
    }
}
