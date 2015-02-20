/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

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
public class PelaajaTest {

    Pelaaja eka = new Pelaaja("yksi", 1);
    Pelaaja toka = new Pelaaja("kaksi", 2);
    Pelaaja kolmas = new Pelaaja("kolme", 2);

    public PelaajaTest() {
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
    public void pienempiVuoroPelaaEnsin() {
        assertEquals(-1, eka.compareTo(toka));
    }

    @Test
    public void isompiVuoroPelaaToisena() {
        assertEquals(1, kolmas.compareTo(eka));
    }

    @Test
    public void samaVuoroAakkosissaAiempiPelaaEnsin() {
        assertEquals(-1, toka.compareTo(kolmas));
    }

    @Test
    public void samaVuoroAakkosisMyohempiPelaaToisena() {
        assertEquals(1, kolmas.compareTo(toka));
    }

    @Test
    public void peliAikaOnAluksiNolla() {
        assertEquals("00:00:00", eka.getPeliAika());
    }

}
