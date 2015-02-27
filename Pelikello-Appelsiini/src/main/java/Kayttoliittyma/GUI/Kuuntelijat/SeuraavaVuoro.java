/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Peli;
import Kayttoliittyma.GUI.PeliRuutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kasperi
 */
public class SeuraavaVuoro implements ActionListener {

    Peli peli;
    PeliRuutu ruutu;

    public SeuraavaVuoro(PeliRuutu ruutu, Peli peli){
        this.peli = peli;
        this.ruutu = ruutu;
    }
    
    @Override
        public void actionPerformed(ActionEvent e) {
            peli.pelattujaVuoroja++;
            peli.vuoroSiirtyy();
            if (peli.pelattujaVuoroja == peli.vuoroRaja * peli.pelaajat.size()) {
                ruutu.loppuTuloksiin();
            } else if (peli.pelattujaVuoroja == peli.vuoroRaja * peli.pelaajat.size() - 1) {
                ruutu.vuorotieto.setText(((peli.pelattujaVuoroja + peli.pelaajat.size()) / peli.pelaajat.size())
                        + ". kierros, VUOROSSA: " + peli.getPelaaja(peli.vuorossa).nimi
                        + " VIIMEINEN VUORO!");
            } else {
                ruutu.setVuorotieto();
            }

            peli.ajastin.alustaAjastin();
            ruutu.aika.setText(peli.ajastin.toString());
            if (!ruutu.laukaisija.isRunning()) {
                ruutu.laukaisija.start();
            }
            if (peli.aikaLoppui) {
                ruutu.loppuTuloksiin();
                ruutu.aikaLoppui.piilota(true);
            }
        }
    
}
