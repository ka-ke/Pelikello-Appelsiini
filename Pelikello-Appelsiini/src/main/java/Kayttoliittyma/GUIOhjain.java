/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Domain.Ajastin;
import Domain.Pelaaja;
import Domain.Peli;
import Kayttoliittyma.GUI.*;
import java.util.ArrayList;

/**
 * Luokka, joka herättää ikkunoita käyttäjän navigoidessa sovelluksen käyttöliittymässä.
 * @author Kasperi
 */
public class GUIOhjain {

    private static Peli peli;
    static PelinAsetukset pelinAsetukset;
    static LisaaPelaajat lisaaPelaajat;
    static PeliRuutu peliruutu;
    static PelinLopputulokset lopputulokset;
    static Ajanotto ajanotto;
    static AjanotonTulokset ajantulokset;
/**
 * Herättää sovelluksen käynnistysikkunan.
 */
    public static void kaynnisty() {
        KaynnistysValikko kaynnistys = new KaynnistysValikko();
        kaynnistys.run();
    }
/**
 * Herättää uuden pelin asetusikkunan.
 */
    public static void alustaPeli() {
        pelinAsetukset = new PelinAsetukset();
        pelinAsetukset.run();
    }
/**
 * Herättää pelaajien lisäys -ikkunan, ja sulkee asetusikkunan.
     * @param pelaajat Tyhjä lista pelaajista.
     * @param vuoroAjastin Asetuksissa luotu vuoroaikaraja-ajastin.
     * @param vuoroja Asetuksissa määrätty vuororaja.
     * @param peliAjastin Asetuksissa luotu peliaikaraja-ajastin.
     * @param pelaajia Asetuksissa määrätty pelaajamäärä.
 */
    public static void luoPelaajat(ArrayList<Pelaaja> pelaajat, Ajastin vuoroAjastin,
            int vuoroja, Ajastin peliAjastin, int pelaajia) {
        pelinAsetukset.nayta(false);

        lisaaPelaajat = new LisaaPelaajat(pelaajat, vuoroAjastin,
                vuoroja, peliAjastin, pelaajia);
        lisaaPelaajat.run();
    }
/**
 * Herättää peliruudun, ja sulkee pelaajien lisäys -ikkunan.
 * @param peli Pelattava peli.
 */
    public static void aloitaPeli(Peli peli) {
        lisaaPelaajat.nayta(false);

        peliruutu = new PeliRuutu(peli);
        peliruutu.run();
    }
/**
 * Herättää lopputulosikkunan ja sulkee peliruudun.
 * @param peli Pelattavan pelin tiedot.
 */
    public static void lopetaPeli(Peli peli) {
        peliruutu.nayta(false);

        lopputulokset = new PelinLopputulokset(peli);
        lopputulokset.run();
    }
/**
 * Herättää ajanotto ikkunan.
 */
    public static void aloitaAjanotto() {
        ajanotto = new Ajanotto();
        ajanotto.run();
    }
/**
 * Herättää ajanoton lopputulos -ikkunan ja sulkee ajanoton.
 * @param ajat 
 */
    public static void lopetaAjanotto(ArrayList<String> ajat) {
        ajanotto.nayta(false);
        ajantulokset = new AjanotonTulokset(ajat);
        ajantulokset.run();
    }
}
