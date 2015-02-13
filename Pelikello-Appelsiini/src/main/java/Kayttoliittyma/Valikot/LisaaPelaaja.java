/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.CheckBox;
import javax.swing.*;
import javax.swing.WindowConstants;
/**
 *
 * @author Kasperi
 */
public class LisaaPelaaja implements Runnable {

    private JFrame laatikko;
    
    @Override
    public void run() {
        
        laatikko = new JFrame("Lisää pelaaja");
        laatikko.setPreferredSize(new Dimension(300, 200));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    private void luoKomponentit(Container loota) {
        
        loota.setLayout(new GridLayout(2,2));
        
        loota.add(new JLabel("Pelaajan nimi:"));
        TextField nimi = new TextField("nimi");
        loota.add(nimi);
        JButton lisaa = new JButton("Lisää");
        loota.add(lisaa);
    }    
}
