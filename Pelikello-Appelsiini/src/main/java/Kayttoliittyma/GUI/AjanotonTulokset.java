/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Ikkuna, joka näyttää ajanotossa tallennetut tulokset yhteenvetona.
 *
 * @author Kasperi
 */
public class AjanotonTulokset implements Runnable {

    private ArrayList ajat;
    private JFrame laatikko;

    /**
     * @param ajat Lista tallenetuista ajoista.
     */
    public AjanotonTulokset(ArrayList<String> ajat) {
        this.ajat = ajat;
    }

    @Override
    public void run() {
        laatikko = new JFrame("Ajanoton tulokset");
        laatikko.setPreferredSize(new Dimension(500, 500));
        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(true);
    }

    private void luoKomponentit(Container loota) {

        JPanel ylaosa = new JPanel();
        JPanel alaosa = new JPanel();
        ylaosa.setLayout(new GridLayout(1, 2));
        alaosa.setLayout(new GridLayout(10, 5));

        JLabel teksti = new JLabel("Alla top50 parasta aikaasi", JLabel.CENTER);

        for (int i = 1; i < ajat.size(); i++) {
            alaosa.add(new JLabel("" + ajat.get(i)));
            if (i == 50) {
                break;
            }
        }

        JButton lopeta = new JButton("Palaa käynnistysvalikkoon");
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nayta(false);
            }
        });

        ylaosa.add(teksti);
        ylaosa.add(lopeta);

        loota.add(ylaosa, BorderLayout.NORTH);
        loota.add(alaosa, BorderLayout.CENTER);
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
