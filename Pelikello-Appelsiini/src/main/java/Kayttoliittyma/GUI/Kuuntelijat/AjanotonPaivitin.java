/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Ajastin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Kasperi
 */
public class AjanotonPaivitin implements ActionListener {

    JLabel paivitettava;
    Ajastin ajastin;
    
    public AjanotonPaivitin(JLabel kuluvaAika, Ajastin ajastin) {
        paivitettava = kuluvaAika;
        this.ajastin = ajastin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ajastin.aikaaMenee();
        paivitettava.setText(ajastin.toString());
    }
    
}
