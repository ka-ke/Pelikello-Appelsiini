/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Kuuntelija ajanoton pysäyttämistä varten.
 *
 * @author Kasperi
 */
public class Pysaytin implements ActionListener {

    private Timer laukaisija;

    /**
     *
     * @param laukaisija Pysäytettävä laukaisija.
     */
    public Pysaytin(Timer laukaisija) {
        this.laukaisija = laukaisija;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (laukaisija.isRunning()) {
            laukaisija.stop();
        } else {
            laukaisija.start();
        }
    }
}
