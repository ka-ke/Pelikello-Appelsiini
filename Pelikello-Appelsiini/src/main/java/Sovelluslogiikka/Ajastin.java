/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasperi
 */
public class Ajastin {
    
    public Laskuri minuutit;
    public Laskuri sekunnit;
    int alkuMinuutit;
    int alkuSekunnit;
    
    public Ajastin(int alkuMinuutit, int alkuSekunnit){
        this.alkuMinuutit = alkuMinuutit;
        this.alkuSekunnit = alkuSekunnit;
        minuutit = new Laskuri(59, alkuMinuutit);
        sekunnit = new Laskuri(59, alkuSekunnit);
    }
    
    public void otaAikaa(){
        while(!this.toString().equals("00:00")){
            System.out.println(this.toString());
            aikaKuluu();
        }
        System.out.println("00:00");
    }
    
    public void aikaKuluu(){
        try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ajastin.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(sekunnit.vahene()){
            minuutit.vahene();
        }
    }
    
    public void alustaAjastin(){
        minuutit.arvo = alkuMinuutit;
        sekunnit.arvo = alkuSekunnit;
    }
    
    @Override
    public String toString(){
        return minuutit.toString()+":"+sekunnit.toString();
    }    
}
