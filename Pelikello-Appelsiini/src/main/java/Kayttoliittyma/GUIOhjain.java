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
 *
 * @author Kasperi
 */
public class GUIOhjain {

    static Peli peli;
    static PelinAsetukset pelinAsetukset;
    static LisaaPelaajat lisaaPelaajat;
    static PeliRuutu peliruutu;
    static PelinLopputulokset lopputulokset;
    static Ajanotto ajanotto;
    static AjanotonTulokset ajantulokset;

    public static void kaynnisty() {
        KaynnistysValikko kaynnistys = new KaynnistysValikko();
        kaynnistys.run();
    }

    public static void alustaPeli() {
        pelinAsetukset = new PelinAsetukset();
        pelinAsetukset.run();
    }

    public static void luoPelaajat(ArrayList<Pelaaja> pelaajat, Ajastin vuoroAjastin,
            int vuoroja, Ajastin peliAjastin, int pelaajia) {
        pelinAsetukset.piilota(false);

        lisaaPelaajat = new LisaaPelaajat(pelaajat, vuoroAjastin,
                vuoroja, peliAjastin, pelaajia);
        lisaaPelaajat.run();
    }

    public static void aloitaPeli(Peli peli) {
        lisaaPelaajat.piilota(false);

        peliruutu = new PeliRuutu(peli);
        peliruutu.run();
    }

    public static void lopetaPeli(Peli peli) {
        peliruutu.piilota(false);

        lopputulokset = new PelinLopputulokset(peli);
        lopputulokset.run();
    }

    public static void aloitaAjanotto() {
        ajanotto = new Ajanotto();
        ajanotto.run();
    }

    public static void lopetaAjanotto(ArrayList<String> ajat) {
        ajanotto.piilota(false);
        ajantulokset = new AjanotonTulokset(ajat);
        ajantulokset.run();
    }
}
