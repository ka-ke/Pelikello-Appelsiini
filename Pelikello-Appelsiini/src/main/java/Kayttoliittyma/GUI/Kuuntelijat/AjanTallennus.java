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

/**
 * Kuuntelija ajanoton ajan tallennusta varten.
 *
 * @author Kasperi
 */
public class AjanTallennus implements ActionListener {

    private ArrayList<String> ajat;
    private Ajastin ajastin;

    /**
     *
     * @param ajat Lista aikoja.
     * @param ajastin Ajastin, jonka tämänhetkinen aika tallennetaan.
     */
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
