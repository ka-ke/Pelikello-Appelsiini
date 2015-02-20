/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasperi
 */
public class PeliTest {

    Peli peli;

    public PeliTest() {
        ArrayList<Pelaaja> pelaajat = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            pelaajat.add(new Pelaaja("" + i, i));
        }

        Ajastin ajastin = new Ajastin(0, 3);
        Ajastin aikaRaja = new Ajastin(0, 0, 10);
        peli = new Peli(ajastin, pelaajat, 2, aikaRaja);
        peli.testataan = true;
        peli.ajastin.testataan = true;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajalistaOnOikeanKokoinen() {
        assertEquals(5, peli.pelaajat.size());
    }

    @Test
    public void vuoroSiirtyyOikein() {
        peli.vuoroSiirtyy();
        assertEquals(1, peli.vuorossa);
    }

    @Test
    public void vuoroSiirtyyYliRajan() {
        for (int i = 0; i < 5; i++) {
            peli.vuoroSiirtyy();
        }
        assertEquals(0, peli.vuorossa);
    }

    @Test
    public void seuraavaPelaajaToimii() {
        peli.setVuorossa(0);
        assertEquals(peli.pelaajat.get(1), peli.getSeuraavaPelaaja());
    }

    @Test
    public void getPelaajaToimii() {
        assertEquals(peli.getPelaaja(1), peli.pelaajat.get(1));
    }

    @Test
    public void getPelaajaPyorahtaaYmpari() {
        assertEquals(peli.getPelaaja(100), peli.pelaajat.get(0));
    }

    @Test
    public void kierrosPyorahtaaYmpari() {
        peli.setVuorossa(peli.pelaajat.size() - 1);
        assertEquals(peli.pelaajat.get(0), peli.getSeuraavaPelaaja());
    }

    @Test
    public void pelatutVuorotKasvavat() {
        peli.pelaaVuoroTekstiKayttoLiittyma();
        assertEquals(1, peli.pelattujaVuoroja);
    }

    @Test
    public void vuoroEiAsetuNegatiiviseksi() {
        int testi = peli.vuorossa;
        peli.setVuorossa(-1);
        assertEquals(testi, peli.vuorossa);
    }

    @Test
    public void vuoroEiAsetuPelaajamaaraaSuuremmaksi() {
        int testi = peli.vuorossa;
        peli.setVuorossa(peli.pelaajat.size() + 5);
        assertEquals(testi, peli.vuorossa);
    }

    @Test
    public void pelaaVuoroGraafisessaLisaaPeliAikaa() {
        peli.pelaaVuoroGraafisessa();
        assertEquals(peli.getPelaaja(peli.vuorossa).peliAika.toString(), "00:00:01");
    }

    @Test
    public void pelaaVuoroGraafisessaTosiJosAikaLoppui() {
        for (int i = 0; i < 11; i++) {
            peli.pelaaVuoroGraafisessa();
        }
        assertEquals(peli.aikaLoppui, true);
    }
}
