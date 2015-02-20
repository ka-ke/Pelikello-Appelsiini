/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import Sovelluslogiikka.Pelaaja;
import Sovelluslogiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Näyttää paljonko kukin pelaaja käytti peliaikaa ja kiittää pelistä.
 *
 * @author Kasperi
 */
public class Lopputulokset {

    Peli peli;
    JFrame laatikko;

    /**
     * @param peli Saa tiedot pelistä.
     */
    public Lopputulokset(Peli peli) {
        this.peli = peli;
    }

    void run() {
        laatikko = new JFrame("Kulutettu peliaika");
        laatikko.setPreferredSize(new Dimension(300, 200));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    /**
     * Alustaa ikkunan sisällön. Jokaista pelaajaa kohden luodaan oma
     * tekstirivinsä.
     */
    private void luoKomponentit(Container loota) {

        BoxLayout y = new BoxLayout(loota, BoxLayout.Y_AXIS);
        loota.setLayout(y);

        for (int i = 0; i < peli.pelaajat.size(); i++) {
            Pelaaja pelaaja = peli.getPelaaja(i);
            loota.add(new JLabel(pelaaja.nimi + ": " + pelaaja.getPeliAika()));
        }

        JButton lopeta = new JButton("Kiitos tiedosta oli kiva peli");
        lopeta.addActionListener(lopetaPeli);
        loota.add(lopeta);
    }
    /**
     * Lopettaa pelin, jolloin käynnistysvalikko jää näkyviin.
     */
    ActionListener lopetaPeli = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            laatikko.setVisible(false);
        }
    };
}
