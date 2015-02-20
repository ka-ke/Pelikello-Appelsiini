/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot.Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Kuuntelija ajanoton pysäyttämistä varten.
 * @author Kasperi
 */
public class Pysaytin implements ActionListener {

    Timer timer;
    
    public Pysaytin(Timer timer){
        this.timer = timer;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
    }
}
