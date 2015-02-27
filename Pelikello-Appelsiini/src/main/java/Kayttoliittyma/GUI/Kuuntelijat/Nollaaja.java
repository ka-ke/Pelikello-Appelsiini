/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Ajastin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Kuuntelija ajanoton nollausta varten.
 *
 * @author Kasperi
 */
public class Nollaaja implements ActionListener {

    private Ajastin ajastin;
    private JLabel kuluvaAika;
    private Timer laukaisin;

    /**
     *
     * @param ajastin Ajastin, jonka aika nollataan.
     * @param kuluvaAika Tekstilaatikko, jonka sisältö päivitetään.
     * @param laukaisin Pysäytettävä laukaisin.
     */
    public Nollaaja(Ajastin ajastin, JLabel kuluvaAika, Timer laukaisin) {
        this.ajastin = ajastin;
        this.kuluvaAika = kuluvaAika;
        this.laukaisin = laukaisin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        laukaisin.stop();
        ajastin.alustaAjastin();
        kuluvaAika.setText(ajastin.toString());

    }
}
