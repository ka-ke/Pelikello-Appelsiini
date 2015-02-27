/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.*;

/**
 * Luokka, joka kokoaa kaiken pelin liittyvän tiedon ja toiminnallisuuden.
 *
 * @author Kasperi
 */
public class Peli {

    /**
     * Pelattujen vuorojen määrä-
     */
    public int pelattujaVuoroja;
    /**
     * Kierrosraja, jonka ylittyessä peli päättyy.
     */
    public int kierrosraja;
    /**
     * Lista peliä pelaavista pelaajista.
     */
    public List<Pelaaja> pelaajat;
    /**
     * Vuoroajastin.
     */
    public Ajastin ajastin;
    /**
     * Kertoo, loppuiko joltakin pelaajalta peliaika.
     */
    public boolean aikaLoppui = false;
    /**
     * Kertoo vuorossa olevan pelajan vuoronumeron.
     */
    public int vuorossa;
    /**
     * Käytetään testien kanssa.
     */
    public boolean testataan = false;
    private Ajastin aikaRaja;

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
        kierrosraja = vuoroja;
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
        aikaLoppui = loppuikoAika();
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

    private boolean loppuikoAika() {
        Ajastin peliAika = getPelaaja(vuorossa).peliAika;
        peliAika.aikaaMenee();
        if (aikaRaja.toString().equals(peliAika.toString())) {
            return true;
        }
        return false;
    }
}
