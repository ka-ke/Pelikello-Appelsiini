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

        peli = new Peli(ajastin, pelaajat, 2);
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
    public void pelaajalistaOnOikeanKokoinen(){
        assertEquals(5,peli.pelaajat.size());
    }
    
    @Test
    public void seuraavaPelaajaToimii(){
        peli.setVuorossa(0);
        assertEquals(peli.pelaajat.get(1), peli.getSeuraavaPelaaja());
    }
    
    @Test
    public void kierrosPyorahtaaYmpari(){
        peli.setVuorossa(peli.pelaajat.size()-1);
        assertEquals(peli.pelaajat.get(0), peli.getSeuraavaPelaaja());
    }
    
    @Test
    public void pelatutVuorotKasvavat(){
        int testi = peli.pelattujaVuoroja;
        peli.pelaaVuoroTekstiKayttoLiittyma();
        assertEquals(testi+1, peli.pelattujaVuoroja);
    }
    
    @Test
    public void vuoroEiAsetuNegatiiviseksi(){
        int testi = peli.vuorossa;
        peli.setVuorossa(-1);
        assertEquals(testi, peli.vuorossa);
    }
    
    @Test
    public void vuoroEiAsetuPelaajamaaraaSuuremmaksi(){
        int testi = peli.vuorossa;
        peli.setVuorossa(peli.pelaajat.size()+5);
        assertEquals(testi, peli.vuorossa);
    }
}
