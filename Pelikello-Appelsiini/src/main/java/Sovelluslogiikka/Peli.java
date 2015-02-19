/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.*;
import java.util.*;

/**
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
//    Ajastin aikaRaja;

// aikarajoittimen toiminnallisuus lisätään vasta graafiseen käyttöliittymään    
    public Peli(Ajastin ajastin, List<Pelaaja> pelaajat, int vuoroja) {
        pelattujaVuoroja = 0;
        vuoroRaja = vuoroja;
        this.ajastin = ajastin;
        this.pelaajat = pelaajat;
//        this.aikaRaja = aikaRaja;
        vuorossa = 0;
    }

    public void vuoroSiirtyy() {
        vuorossa++;
        if (vuorossa == pelaajat.size()) {
            vuorossa = 0;
        }
    }

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

    public void pelaaVuoroGraafisessa() {
        getPelaaja(vuorossa).peliAika.aikaaMenee();
        ajastin.aikaKuluu();
    }

    public void setVuorossa(int vuoro) {
        if (vuoro >= 0 && vuoro < pelaajat.size()) {
            vuorossa = vuoro;
        }
    }

    public Pelaaja getPelaaja(int vuoro) {
        if (vuoro >= pelaajat.size()) {
            return pelaajat.get(0);
        }
        return pelaajat.get(vuoro);
    }

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
