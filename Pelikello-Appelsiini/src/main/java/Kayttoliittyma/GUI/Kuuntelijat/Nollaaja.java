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
public class Nollaaja implements ActionListener {

    Ajastin ajastin;
    JLabel kuluvaAika;
    
    public Nollaaja(Ajastin ajastin, JLabel kuluvaAika){
        this.ajastin = ajastin;
        this.kuluvaAika = kuluvaAika;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ajastin.alustaAjastin();
        kuluvaAika.setText(ajastin.toString());
    }
}
