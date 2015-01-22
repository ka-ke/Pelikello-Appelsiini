/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
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

        
        Kellonluonti testi = new Kellonluonti();
        Ajastin testiAjastin = testi.luoKello();
        
        ArrayList<Pelaaja> vuorolista = new ArrayList();
        vuorolista.add(new Pelaaja("Teemu", 3));
        vuorolista.add(new Pelaaja("ASIDOJHqwd", 100));
        vuorolista.add(new Pelaaja("Jaana", 1));
        vuorolista.sort(null);

        VuoronEteneminen vuoro = new VuoronEteneminen(testiAjastin);
        
        for(int i=0; i<vuorolista.size(); i++){
            System.out.println("Paina enter niin seuraavan pelaajan vuoro alkaa");
            String vastaus = nappainsyote.lueRivi();
            vuoro.ajastaVuoro(vuorolista.get(i));
        }
    }
}
