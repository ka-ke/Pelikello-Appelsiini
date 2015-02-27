/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Kayttoliittyma.GUI.Kuuntelijat.Nollaaja;
import Kayttoliittyma.GUI.Kuuntelijat.AjanTallennus;
import Kayttoliittyma.GUI.Kuuntelijat.AjanotonPaivitin;
import Domain.Ajastin;
import Kayttoliittyma.GUI.Kuuntelijat.Pysaytin;
import Kayttoliittyma.GUIOhjain;
import java.awt.BorderLayout;
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
public class Ajanotto implements Runnable {

    JFrame laatikko;
    Timer laukaisin;
    Ajastin ajastin = new Ajastin(0, 0);
    ArrayList<String> ajat;

    @Override
    public void run() {
        ajat = new ArrayList();

        laatikko = new JFrame("Ajanotto");
        laatikko.setPreferredSize(new Dimension(500, 500));
        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    private void luoKomponentit(Container loota) {
        JLabel kuluvaAika = new JLabel(ajastin.toString());
        JButton stop = new JButton("ON/OFF");
        JButton nollaa = new JButton("Nollaa");
        JButton tallenna = new JButton("Tallenna aika");
        JButton lopeta = new JButton("Lopeta ajanotto ja näytä tulokset");

        laukaisin = new Timer(1000, new AjanotonPaivitin(kuluvaAika, ajastin));
        Pysaytin pysaytin = new Pysaytin(laukaisin);
        Nollaaja nollaaja = new Nollaaja(ajastin, kuluvaAika);

        tallenna.addActionListener(new AjanTallennus(ajat, ajastin));
        nollaa.addActionListener(nollaaja);
        nollaa.addActionListener(pysaytin);
        stop.addActionListener(pysaytin);

        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIOhjain.lopetaAjanotto(ajat);
            }
        });

        loota.add(kuluvaAika, BorderLayout.CENTER);
        loota.add(lopeta, BorderLayout.SOUTH);
        loota.add(nollaa, BorderLayout.NORTH);
        loota.add(tallenna, BorderLayout.EAST);
        loota.add(stop, BorderLayout.WEST);
    }

    public void piilota(boolean b) {
        laatikko.setVisible(b);
    }
}
