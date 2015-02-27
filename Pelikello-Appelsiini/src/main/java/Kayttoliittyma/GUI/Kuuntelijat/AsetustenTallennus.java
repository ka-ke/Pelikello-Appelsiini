/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Kayttoliittyma.GUI.LisaaPelaajat;
import Kayttoliittyma.GUI.PelinAsetukset;
import Domain.Ajastin;
import Domain.Pelaaja;
import Kayttoliittyma.GUIOhjain;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Kasperi
 */
public class AsetustenTallennus implements ActionListener {

    PelinAsetukset asetukset;

    public AsetustenTallennus(PelinAsetukset asetukset) {
        this.asetukset = asetukset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int vuoroja;
        int pelaajia;

        try {
            vuoroja = Integer.parseInt(asetukset.vuorojaText.getText());
            pelaajia = Integer.parseInt(asetukset.pelaajiaText.getText());
        } catch (Exception ex) {
            asetukset.virhe.piilota(true);
            return;
        }
        if (pelaajia < 1) {
            asetukset.virhe.piilota(true);
            return;
        }
        if (vuoroja < 0) {
            asetukset.virhe.piilota(true);
            return;
        }

        Ajastin vuoroAjastin;
        Ajastin peliAjastin;

        try {
            vuoroAjastin = new Ajastin(Integer.parseInt(asetukset.min.getText()),
                    Integer.parseInt(asetukset.sek.getText()));
            peliAjastin = new Ajastin(Integer.parseInt(asetukset.minAika.getText()),
                    Integer.parseInt(asetukset.sekAika.getText()));
        } catch (Exception ex) {
            asetukset.virhe.piilota(true);
            return;
        }
        if (vuoroAjastin.toString().equals("00:00")) {
            asetukset.virhe.piilota(true);
            return;
        }

        GUIOhjain.luoPelaajat(new ArrayList<Pelaaja>(),
                vuoroAjastin, vuoroja, peliAjastin, pelaajia);
    }
}
