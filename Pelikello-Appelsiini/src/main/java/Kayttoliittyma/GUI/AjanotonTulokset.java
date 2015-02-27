/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Kasperi
 */
public class AjanotonTulokset implements Runnable {

    ArrayList ajat;
    JFrame laatikko;

    public AjanotonTulokset(ArrayList<String> ajat) {
        this.ajat = ajat;
    }

    @Override
    public void run() {
        laatikko = new JFrame("Ajanoton tulokset");
        laatikko.setPreferredSize(new Dimension(500, 500));
        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    private void luoKomponentit(Container loota) {

        BoxLayout y = new BoxLayout(loota, BoxLayout.Y_AXIS);
        loota.setLayout(y);

        JLabel teksti = new JLabel("Aikasi pienimmästä suurimpaan:");
        loota.add(teksti);

        for (Object aika : ajat) {
            loota.add(new JLabel("" + aika));
        }

        JButton lopeta = new JButton("Kiitos tiedosta ja näkemiin");
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laatikko.setVisible(false);
            }
        });

        loota.add(lopeta);
    }
}
