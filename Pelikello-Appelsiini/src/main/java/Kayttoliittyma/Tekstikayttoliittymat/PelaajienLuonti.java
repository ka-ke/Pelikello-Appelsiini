/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;
import Kayttoliittyma.Lukija;
import java.util.*;
import Sovelluslogiikka.Pelaaja;
/**
 *
 * @author Kasperi
 */
public class PelaajienLuonti {
    
    Lukija lukija;
    
    public PelaajienLuonti(){
        lukija = new Lukija();
    }
    
    public ArrayList<Pelaaja> luoPelaajat(){
        
        ArrayList<Pelaaja> pelaajat = new ArrayList();
        System.out.println("Montako pelaajaa on pelissä?");
        int pelaajia = -1;
        
        while(pelaajia<=0 || pelaajia>10){
           System.out.println("Pelaajanmäärä on vähintään 1 ja enintään 10");
           pelaajia = lukija.lueLuku();
        }
        
        for(int i=1; i<= pelaajia; i++){
            Pelaaja uusi = luoPelaaja(i);
            pelaajat.add(uusi);
        }
        pelaajat.sort(null);
        return pelaajat;
    }
    
    public Pelaaja luoPelaaja(int vuoro){
        
        String nimi = "";
        System.out.println(vuoro+". pelaavan nimi?");
        while(nimi.equals("")){
            nimi = lukija.lueRivi();
        } 
        return new Pelaaja(nimi, vuoro);
    }
}
