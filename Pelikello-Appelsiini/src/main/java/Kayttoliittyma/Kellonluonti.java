/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
import Sovelluslogiikka.Ajastin;
/**
 *
 * @author Kasperi
 */
public class Kellonluonti {
    
    Lukija lukija;
    
    public Kellonluonti(){
        lukija = new Lukija();
    }
    
    public Ajastin luoKello(){
        
        System.out.println("Paljonko aikaa per vuoro?");
        System.out.println("Syötä ensin minuutit ja sitten sekuntit muodossa AB CD");
        
        int minuuttejaVuorossa = lukija.lueLuku();
        int sekuntejaVuorossa = lukija.lueLuku();
        
        System.out.println("Pelaajalla on aikaa per vuoro "+minuuttejaVuorossa+" minuuttia ja "
                +sekuntejaVuorossa+" sekuntia.");
        
        System.out.println("Asetetaanko pelaajille peliaikaa, jonka ylittyessä pelin häviää?");
        System.out.println("Vastaa joo tai ei");
        
        String vastaus = lukija.lueSana();
        if(vastaus.equalsIgnoreCase("joo")){
            System.out.println("Paljon aikaa per pelaaja?");
            System.out.println("Syötä ensin tunnit, toiseksi minuutit ja kolmanneksi sekunnit muodossa AB CD EF");
            
            int tuntiRaja = lukija.lueLuku();
            int minuuttiRaja = lukija.lueLuku();
            int sekuntiRaja = lukija.lueLuku();
            
            System.out.println("Pelaajalla on aikaa voittaa peli "+tuntiRaja+" tuntia "+minuuttiRaja+" minuuttia ja "
                    +sekuntiRaja+" sekuntia.");
        }
        
        System.out.println("Kirjoita aloita kun olet valmis aloittamaan pelin");
        vastaus = lukija.lueSana();
        while(!vastaus.equals("aloita")){
        vastaus = lukija.lueSana();
        }
        return new Ajastin(minuuttejaVuorossa, sekuntejaVuorossa);
    }
}
