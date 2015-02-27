/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.*;
import java.util.*;

/**
 * Luokka, joka kokoaa kaiken pelin liittyvän tiedon ja toiminnallisuuden.
 *
 * @author Kasperi
 */
public class Peli {

    public int pelattujaVuoroja;
    public int vuoroRaja;
    public int vuorossa;
    public List<Pelaaja> pelaajat;
    public Ajastin ajastin;
    public boolean testataan = false;
    public boolean aikaLoppui = false;
    Ajastin aikaRaja;

    /**
     * Asettaa myös pelatut vuorot ja ensimmäisen vuoronumeron nollaksi.
     *
     * @param ajastin Ajastin, jonka mukaan mitataan pelivuoron kestoa.
     * @param pelaajat Lista mukana olevista pelaajista.
     * @param vuoroja Määrää pelattavien vuorojen lukumäärän jos positiivnen.
     * @param aikaRaja Määrää käytössä olevan ajan, mikäli yli sekunnin.
     */
    public Peli(Ajastin ajastin, List<Pelaaja> pelaajat, int vuoroja, Ajastin aikaRaja) {
        pelattujaVuoroja = 0;
        vuoroRaja = vuoroja;
        this.ajastin = ajastin;
        this.pelaajat = pelaajat;
        this.aikaRaja = aikaRaja;
        vuorossa = 0;
    }

    /**
     * Vuoronumero kasvaa yhdellä tai palaa alkuun.
     */
    public void vuoroSiirtyy() {
        vuorossa++;
        if (vuorossa == pelaajat.size()) {
            vuorossa = 0;
        }
    }

    /**
     * Tekstikäyttöliittymässä käytetty vuoronetenemiseen.
     */
    public void pelaaVuoroTekstiKayttoLiittyma() {
        Pelaaja pelaaja = pelaajat.get(vuorossa);

        while (!ajastin.toString().equals("00:00")) {
            if (testataan == false) { // testejä ajaessa ei tarvitse turhaan tulostella
                System.out.println(ajastin);
            }
            ajastin.aikaKuluu();
        }
        ajastin.alustaAjastin();
        pelattujaVuoroja++;
    }

    /**
     * GUI:ssa käytettävä metodi ajanmittaamiseen. Vähentää vuoron aikaa, lisää
     * pelaajan pelattua aikaa ja tarkistaa, loppuuko peliaika.
     */
    public void pelaaVuoroGraafisessa() {
        ajastin.aikaKuluu();
        Ajastin peliAika = getPelaaja(vuorossa).peliAika;
        peliAika.aikaaMenee();
        if (aikaRaja.toString().equals(peliAika.toString())) {
            aikaLoppui = true;
        }
    }

    /**
     * @param vuoro Asettaa vuoron annetuksi pelaajien rajoissa.
     */
    public void setVuorossa(int vuoro) {
        if (vuoro >= 0 && vuoro < pelaajat.size()) {
            vuorossa = vuoro;
        }
    }

    /**
     * @param vuoro Vuoropaikka, jolla oleva pelaaja tahdotaan selvittää.
     * @return Palauttaa vuoropaikalla vuoro.
     */
    public Pelaaja getPelaaja(int vuoro) {
        if (vuoro >= pelaajat.size()) {
            return pelaajat.get(0);
        }
        return pelaajat.get(vuoro);
    }

    /**
     * @return Palauttaa seuraavaksi pelaavan pelaajan.
     */
    public Pelaaja getSeuraavaPelaaja() {
        if (vuorossa == pelaajat.size() - 1) {
            return pelaajat.get(0);
        }
        return pelaajat.get(vuorossa + 1);
    }
//    public void poistaPelaaja(Pelaaja poistettava) {
//        pelaajat.remove(poistettava);
//        pelaajat.sort(null);
//    }
}
