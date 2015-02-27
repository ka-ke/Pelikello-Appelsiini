/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Ajastin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Kasperi
 */
public class AjanTallennus implements ActionListener {

    ArrayList<String> ajat;
    Ajastin ajastin;
    
    public AjanTallennus(ArrayList<String> ajat, Ajastin ajastin) {
        this.ajat = ajat;
        this.ajastin = ajastin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ajat.add(ajastin.toString());
        ajat.sort(null);
    }
}
