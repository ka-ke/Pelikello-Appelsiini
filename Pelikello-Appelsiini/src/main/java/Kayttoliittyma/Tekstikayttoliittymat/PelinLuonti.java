/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;
import Kayttoliittyma.Lukija;
import Sovelluslogiikka.*;
import java.util.*;
/**
 *
 * @author Kasperi
 */
public class PelinLuonti {
    
    Lukija lukija;
    
    public PelinLuonti(){
        lukija = new Lukija();
    }
    
    public Peli luoPeli(List pelaajat, Ajastin ajastin){
        
//        System.out.println("Asetetaanko pelaajille peliaikaa, jonka ylittyessä pelin häviää?");
//        System.out.println("Vastaa kyl halutessasi rajoituksen peliajalle.");
//        
//        String vastaus = lukija.lueRivi();
//        if(vastaus.equalsIgnoreCase("kyl")){
//            System.out.println("Paljon aikaa per pelaaja?");
//            System.out.println("Syötä ensin tunnit, toiseksi minuutit ja kolmanneksi sekunnit enterillä eroteltuina");
//            
//            int tuntiRaja = lukija.lueLuku();
//            int minuuttiRaja = lukija.lueLuku();
//            int sekuntiRaja = lukija.lueLuku();
//            
//            System.out.println("Pelaajalla on aikaa pelata "+tuntiRaja+" tuntia "+minuuttiRaja+" minuuttia ja "
//                    +sekuntiRaja+" sekuntia.");
//        }         
        
        System.out.println("Asetetaanko pelille vuororajaa, jonka jälkeen peli päättyy?");
        System.out.println("Vastaa kyl halutessasi rajoituksen vuoroille.");
        
        String vastaus = lukija.lueRivi();
        if(vastaus.equalsIgnoreCase("kyl")){
            System.out.println("Montako vuoroa?");
            int vuoroja = lukija.lueLuku();
            return new Peli(ajastin, pelaajat, vuoroja);
        }
        return new Peli(ajastin, pelaajat);
    }
}
