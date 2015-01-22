/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
import Sovelluslogiikka.*;
/**
 *
 * @author Kasperi
 */
public class VuoronEteneminen {
    
    public Ajastin ajastin;
    
    public VuoronEteneminen(Ajastin ajastin){
        this.ajastin = ajastin;
    }
    
    public void ajastaVuoro(Pelaaja pelaava){
        System.out.println(pelaava.nimi+"n vuoro, aikaa alkaa nyt!");
        ajastin.otaAikaa();
        ajastin.alustaAjastin();
    }
    
}
