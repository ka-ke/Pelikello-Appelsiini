package Sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Sovelluslogiikka.Laskuri;

/**
 *
 * @author Kasperi
 */
public class LaskuriTest {
    
    public Laskuri laskija;
    
    public LaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        laskija = new Laskuri(99, 50);
    }
    
    @After
    public void tearDown() {
   
    }
    
    @Test
    public void eiVoiAlustaaNegatiivistaArvoa(){
        Laskuri negatiivi = new Laskuri(99, -50);
        assertEquals(0, negatiivi.arvo);
    }
    
    @Test
    public void rajaEiVoiOllaNegatiivinen(){
        Laskuri negatiivi = new Laskuri(-1, 10);
        assertEquals(59, negatiivi.raja);
    }
    
    @Test
    public void arvoEiVoiAlustaaRajaaSuuremmaksi(){
        Laskuri pieniraja = new Laskuri(5, 10);
        assertEquals(pieniraja.raja, pieniraja.arvo);
    }
    
    @Test
    public void arvoKasvaaEdetessa(){
        laskija.etene();
        assertEquals(51, laskija.arvo);
    }
    
    @Test
    public void rajallaEdetessaTuleeNolla(){                
        for(int i=0; i<50; i++){
            laskija.etene();
        }
        assertEquals(0, laskija.arvo);
    }
    
    @Test
    public void arvoPieneneeVahentyessa(){
        laskija.vahene();
        assertEquals(49, laskija.arvo);
    }
    
    @Test
    public void nollassaVahentyessaTuleeRaja(){
        for(int i=0; i<51; i++){
            laskija.vahene();
        }
        assertEquals(99, laskija.arvo);
    }
    
    @Test
    public void arvoAsettuuOikein(){
        laskija.setArvo(42);
        assertEquals(42, laskija.arvo);
    }
    
    @Test
    public void asettaessaNegatiivinenArvoTuleeNolla(){
        laskija.setArvo(-7);
        assertEquals(0, laskija.arvo);
    }
    
    @Test
    public void eiVoiAsettaaRajaaSuurempaaArvoa(){
        laskija.setArvo(100);
        assertEquals(laskija.raja, laskija.arvo);
    }
    
    @Test
    public void alleKympinArvoTulostuuOikein(){
        laskija.setArvo(8);
        assertEquals("08", laskija.toString());
    }
    
    @Test
    public void yliKympinArvoTulostuuOikein(){
        assertEquals("50", laskija.toString());
    }
}
