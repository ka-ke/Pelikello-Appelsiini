/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;

import Domain.Peli;
import Domain.Pelaaja;

/**
 * Tekstikäyttöliittymässä pelin etenemistä ohjaava luokka. Ei enää käytössä
 * GUI:n valmistuttua.
 *
 * @author Kasperi
 */
public class PelinOhjaaja {

    Lukija lukija;
    Peli peli;

    public PelinOhjaaja(Lukija lukija, Peli peli) {

        this.peli = peli;
        this.lukija = lukija;
    }

    public void pelaaPeli() {
        aloitaPeli();

        while (true) {
            String vastaus = "-1";
            System.out.println("Paina enter niin seuraavan pelaajan vuoro alkaa");
            while (!vastaus.equals("")) {
                vastaus = lukija.lueRivi();
            }
            seuraavanVuoro();
            if (peli.pelattujaVuoroja == peli.vuoroRaja) {
                break;
            }
        }
    }

    public void aloitaPeli() {
        System.out.println("Kirjoita aloita kun olet valmis aloittamaan pelin");
        String vastaus = lukija.lueRivi();
        while (!vastaus.equals("aloita")) {
            vastaus = lukija.lueRivi();
        }

        System.out.println("Pelin aloittaa: " + peli.pelaajat.get(peli.vuorossa).nimi);
        peli.pelaaVuoroTekstiKayttoLiittyma();
    }

    public void seuraavanVuoro() {
        Pelaaja pelaaja = peli.getSeuraavaPelaaja();
        System.out.println("Vuorossa: " + pelaaja.nimi);
        peli.pelaaVuoroTekstiKayttoLiittyma();
    }

    public void lopetaPeli() {

    }
}
