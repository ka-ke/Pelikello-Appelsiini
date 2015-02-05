package Sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Sovelluslogiikka.Ajastin;
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
public class AjastinTest {
    
    public Ajastin ajastin = new Ajastin(0, 1, 10);
    
    public AjastinTest() {
        ajastin.testataan = true;
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
    public void alustuuOikein(){
        assertEquals(0, ajastin.tunnit.arvo);
        assertEquals(1, ajastin.minuutit.arvo);
        assertEquals(10, ajastin.sekunnit.arvo);
    }
    
    @Test
    public void eiVoiAlustaaNegatiivisiaArvoja(){
        Ajastin nega = new Ajastin(-5, -23);
        assertEquals(0, nega.minuutit.arvo);
        assertEquals(0, nega.sekunnit.arvo);
    }
    
    @Test
    public void aloitusArvotEnintaan59(){
        Ajastin suuretArvot = new Ajastin(99, 202);
        assertEquals(suuretArvot.sekunnit.raja, suuretArvot.sekunnit.arvo);
        assertEquals(suuretArvot.minuutit.raja, suuretArvot.minuutit.arvo);
    }
    
    @Test
    public void aikaVaheneeKunSitaKuluu(){
        ajastin.aikaKuluu();
        assertEquals("00:01:09", ajastin.toString());
    }
    
    @Test
    public void minuuttiVaheneeOikein(){
        for(int i=0; i<11; i++){
            ajastin.aikaKuluu();
        }
        assertEquals("00:00:59", ajastin.toString());
    }
    
    @Test
    public void ajastuksenLoppuessaAikaaEiOle(){
        Ajastin pika = new Ajastin(0, 3);
        for(int i=0; i<pika.alkuSekunnit; i++){
            pika.aikaKuluu();
        }
        assertEquals("00:00", pika.toString());
    }
    
    @Test
    public void ajanOtonJalkeenAlustusToimii(){
        Ajastin pika = new Ajastin(0, 3);
        for(int i=0; i<pika.alkuSekunnit; i++){
            pika.aikaKuluu();
        }
        pika.alustaAjastin();
        assertEquals("00:03", pika.toString());
    }
}
