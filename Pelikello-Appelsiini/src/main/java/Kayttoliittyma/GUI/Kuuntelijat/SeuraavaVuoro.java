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
 * Kuuntelija, joka siirtää vuoroa eteenpäin ja päivittää ruudun komponentteja.
 *
 * @author Kasperi
 */
public class SeuraavaVuoro implements ActionListener {

    private Peli peli;
    private PeliRuutu ruutu;

    /**
     *
     * @param ruutu Peliruutu, jossa vuoro etenee.
     * @param peli Peli, jota pelataan.
     */
    public SeuraavaVuoro(PeliRuutu ruutu, Peli peli) {
        this.peli = peli;
        this.ruutu = ruutu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.pelattujaVuoroja++;
        peli.vuoroSiirtyy();
        if (peli.pelattujaVuoroja == peli.kierrosraja * peli.pelaajat.size()) {
            ruutu.loppuTuloksiin();
        } else if (peli.pelattujaVuoroja == peli.kierrosraja * peli.pelaajat.size() - 1) {
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
            ruutu.aikaLoppui.nayta(true);
        }
    }

}
