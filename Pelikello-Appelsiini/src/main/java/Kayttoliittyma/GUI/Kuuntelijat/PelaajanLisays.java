/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import Domain.Pelaaja;
import Domain.Peli;
import Kayttoliittyma.GUI.LisaaPelaajat;
import Kayttoliittyma.GUIOhjain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kuuntelija, joka Lisaapelaajat-ikkunan painikkeelle toiminnallisuuden lisätä
 * nimimerkkejä Pelaajalistaan.
 *
 * @author Kasperi
 */
public class PelaajanLisays implements ActionListener {

    private LisaaPelaajat asetukset;

    /**
     *
     * @param asetukset LisaaPelaajat ikkuna asetuksineen, jotta voidaan
     * palauttaa Peli GUIOhjaimelle.
     */
    public PelaajanLisays(LisaaPelaajat asetukset) {
        this.asetukset = asetukset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nimi = asetukset.nimiText.getText().trim();

        if (nimi.isEmpty()) {
            asetukset.huonoNimi.nayta(true);
            return;
        }

        for (Pelaaja p : asetukset.pelaajat) {
            if (p.nimi.equals(nimi)) {
                asetukset.samaNimi.nayta(true);
                return;
            }
        }

        asetukset.pelaajat.add(new Pelaaja(nimi, asetukset.lisattava));
        asetukset.nimiText.setText("");
        asetukset.lisattava++;

        if (asetukset.lisattava > asetukset.pelaajia) {
            asetukset.laatikko.setVisible(false);
            GUIOhjain.aloitaPeli(new Peli(asetukset.ajastin, asetukset.pelaajat,
                    asetukset.vuoroja, asetukset.aikaRaja));
        }
    }
}
