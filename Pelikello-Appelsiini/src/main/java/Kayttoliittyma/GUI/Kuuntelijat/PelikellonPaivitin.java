/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Aaniefektit.Aani;
import Domain.Ajastin;
import Domain.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Kuuntelija pelin ajan digitaaliesityksen reaaliaikaista päivittämistä varten.
 *
 * @author Kasperi
 */
public class PelikellonPaivitin implements ActionListener {

    private Peli peli;
    private JLabel label;

    /**
     * @param label Sisältää päivitettävän kellonajan digitaaliesityksen.
     * @param peli Peli, jonka ajanottoa käsitellään.
     */
    public PelikellonPaivitin(JLabel label, Peli peli) {
        this.label = label;
        this.peli = peli;
    }

    /**
     * Kutsuu pelin metodia ajastimen edistämiseksi ja päivittää
     * digitaaliesityksen.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!peli.ajastin.toString().equals("00:00")) {
            peli.pelaaVuoroGraafisessa();
            if (peli.ajastin.toString().equals("00:00")) {
                Aani.aikaLoppui.toista();
            } else if (peli.ajastin.minuutit.arvo == 0 && peli.ajastin.sekunnit.arvo <= 5) {
                Aani.aikaVahenee.toista();
            }
            label.setText("" + peli.ajastin.toString());

        }
    }
}
