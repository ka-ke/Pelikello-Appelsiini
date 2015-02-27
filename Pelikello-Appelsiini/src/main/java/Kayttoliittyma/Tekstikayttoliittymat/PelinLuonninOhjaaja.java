/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;

import Domain.Ajastin;
import Domain.Pelaaja;
import Domain.Peli;
import java.util.ArrayList;
import java.util.List;

/**
 * Tekstikäyttöliittymällä käytettävä pelin luoja, ei käytössä GUI:n
 * valmistuttua.
 *
 * @author Kasperi
 */
public class PelinLuonninOhjaaja {

    Lukija lukija;
    ArrayList<Pelaaja> pelaajat;

    public PelinLuonninOhjaaja(Lukija lukija) {
        this.lukija = lukija;
        pelaajat = new ArrayList();
    }

    public Peli luoPeli() {

        pelaajat = luoPelaajat();
        Ajastin ajastin = luoAjastin();
//        Ajastin aikaRajoitin = asetaAikaRajoitin();
        int vuoroRajoitin = asetaVuoroRajoitin() * pelaajat.size();

        return new Peli(ajastin, pelaajat, vuoroRajoitin, null);
    }

    public Ajastin luoAjastin() {
        int minuuttejaVuorossa = -1;
        int sekuntejaVuorossa = -1;

        System.out.println("Paljonko aikaa per vuoro? Syötä ensin minuutit ja sitten "
                + "sekuntit enterillä eroteltuna");

        while (minuuttejaVuorossa <= 0 && sekuntejaVuorossa <= 0
                || minuuttejaVuorossa > 59 || sekuntejaVuorossa > 59) {
            System.out.println("Vuoron on kestettävä vähintään 1 sekunti ja enintään "
                    + "59 minuuttia ja 59 sekuntia");
            minuuttejaVuorossa = lukija.lueLuku();
            sekuntejaVuorossa = lukija.lueLuku();
        }

        Ajastin ajastin = new Ajastin(minuuttejaVuorossa, sekuntejaVuorossa);
        System.out.println("Pelaajalla on aikaa per vuoro " + ajastin.minuutit + " minuuttia ja "
                + ajastin.sekunnit + " sekuntia.");
        return ajastin;
    }

    public ArrayList<Pelaaja> luoPelaajat() {

        System.out.println("Montako pelaajaa on pelissä?");
        int pelaajia = -1;

        while (pelaajia <= 0 || pelaajia > 10) {
            System.out.println("Pelaajanmäärä on vähintään 1 ja enintään 10");
            pelaajia = lukija.lueLuku();
        }

        for (int i = 1; i <= pelaajia; i++) {
            Pelaaja uusi = luoPelaaja(i);
            pelaajat.add(uusi);
        }
        pelaajat.sort(null);
        return pelaajat;
    }

    public Pelaaja luoPelaaja(int vuoro) {

        String nimi = "";
        System.out.println(vuoro + ". vuorossa olevan pelaajan nimi?");

        while (nimi.equals("")) {
            nimi = lukija.lueRivi();

            for (Pelaaja p : pelaajat) {
                if (p.nimi.equals(nimi)) {
                    System.out.println("Nimimerkki on jo varattu, valitse jokin muu.");
                    nimi = "";
                }
            }
        }
        return new Pelaaja(nimi, vuoro);
    }

    public int asetaVuoroRajoitin() {

        System.out.println("Asetetaanko vuororajaa, jonka jälkeen peli päättyy?");
        System.out.println("Vastaa kyl halutessasi rajoituksen vuoroille.");

        String vastaus = lukija.lueRivi();
        if (vastaus.equalsIgnoreCase("kyl")) {
            System.out.println("Syötä monta vuoroa kukin pelaaja pelaa.");

            int vuoroja = -1;
            while (vuoroja <= 0) {
                vuoroja = lukija.lueLuku();
            }
            return vuoroja;
        }
        return -1;
    }

// aikarajoittimen toiminnallisuus lisätään vasta graafiseen käyttöliittymään
//    public Ajastin asetaAikaRajoitin() {
//
//        System.out.println("Asetetaanko pelaajille peliaikaa, jonka ylittyessä pelin häviää?");
//        System.out.println("Vastaa kyl halutessasi rajoituksen peliajalle.");
//
//        String vastaus = lukija.lueRivi();
//        if (vastaus.equalsIgnoreCase("kyl")) {
//            System.out.println("Paljon aikaa per pelaaja?");
//            System.out.println("Syötä ensin tunnit, toiseksi minuutit ja kolmanneksi sekunnit "
//                    + "enterillä eroteltuina");
//
//            int tuntiRaja = -1;
//            int minuuttiRaja = -1;
//            int sekuntiRaja = -1;
//
//            while (tuntiRaja <= 0 && minuuttiRaja < 1 && sekuntiRaja <= 0 
//                    || tuntiRaja > 23 || minuuttiRaja > 59 || sekuntiRaja > 59) {
//
//                System.out.println("Aikaraja on vähintään 1 minuutti ja enintään 23 tuntia 59 minuuttia ja 59 sekuntia");
//                
//                tuntiRaja = lukija.lueLuku();
//                minuuttiRaja = lukija.lueLuku();
//                sekuntiRaja = lukija.lueLuku();
//            }
//
//            Ajastin ajastin = new Ajastin(tuntiRaja, minuuttiRaja, sekuntiRaja);
//
//            System.out.println("Pelaajalla on aikaa pelata " + ajastin.tunnit + " tuntia " + ajastin.minuutit + " minuuttia ja "
//                    + ajastin.sekunnit + " sekuntia.");
//            return ajastin;
//        }
//        return new Ajastin(-1, -1, -1);
//    }
}
