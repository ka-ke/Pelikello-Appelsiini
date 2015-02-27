/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot.Kuuntelijat;

import Sovelluslogiikka.Ajastin;
import Sovelluslogiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
/**
 * Kuuntelija ajan digitaaliesityksen reaaliaikaista päivittämistä varten.
 * @author Kasperi
 */
public class Paivitin implements ActionListener {

    private Peli peli;
    private JLabel label;
/**
     * @param label Sisältää päivitettävän kellonajan digitaaliesityksen.
     * @param peli Peli, jonka ajanottoa käsitellään.
 */
    public Paivitin(JLabel label, Peli peli) {
        this.label = label;
        this.peli = peli;
    }
/**
 * Kutsuu pelin metodia ajastimen edistämiseksi ja päivittää digitaaliesityksen.
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!peli.ajastin.toString().equals("00:00")) {
            peli.pelaaVuoroGraafisessa();
            label.setText("" + peli.ajastin.toString());
        }
    }
}
