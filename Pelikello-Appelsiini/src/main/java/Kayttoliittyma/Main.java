/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
import Kayttoliittyma.Tekstikayttoliittymat.*;
import Kayttoliittyma.*;
import Sovelluslogiikka.*;
import java.util.*;

/**
 *
 * @author Kasperi
 */
public class Main {
    
    static Lukija nappainsyote = new Lukija();
    
    public static void main(String[] args) {

        
        KellonLuonti luoKello = new KellonLuonti();
        PelaajienLuonti luoPelaajat = new PelaajienLuonti();
        PelinLuonti luoPeli = new PelinLuonti();
        
        Ajastin testiAjastin = luoKello.luoKello();
        ArrayList<Pelaaja> testilista = luoPelaajat.luoPelaajat();
        Peli testipeli = luoPeli.luoPeli(testilista, testiAjastin);
                
        System.out.println("Kirjoita aloita kun olet valmis aloittamaan pelin");
        String vastaus = nappainsyote.lueRivi();
        while(!vastaus.equals("aloita")){
            vastaus = nappainsyote.lueRivi();
        }
        
        System.out.println("Pelin aloittaa: "+testilista.get(testipeli.vuorossa).nimi);
        testipeli.aloitaPeli();
        
        while(true){
            vastaus = "-1";
            System.out.println("Paina enter niin seuraavan pelaajan vuoro alkaa");
            while(!vastaus.equals("")){
            vastaus = nappainsyote.lueRivi();
            }
            testipeli.seuraavaVuoro();
            if(testipeli.pelattujaVuoroja==testipeli.vuoroRaja){
                break;
            }
        }
    }
}
