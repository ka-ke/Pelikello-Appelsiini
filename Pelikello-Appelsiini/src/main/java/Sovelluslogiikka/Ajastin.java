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

    public Laskuri tunnit;
    public Laskuri minuutit;
    public Laskuri sekunnit;
    int alkuTunnit;
    int alkuMinuutit;
    int alkuSekunnit;
//    boolean kaynnissa;
    boolean testataan = false;

    public Ajastin(int alkuTunnit, int alkuMinuutit, int alkuSekunnit) {
        this.alkuTunnit = alkuTunnit;
        this.alkuMinuutit = alkuMinuutit;
        this.alkuSekunnit = alkuSekunnit;
        tunnit = new Laskuri(23, alkuTunnit);
        minuutit = new Laskuri(59, alkuMinuutit);
        sekunnit = new Laskuri(59, alkuSekunnit);
//        kaynnissa = true;
    }

    public Ajastin(int alkuMinuutit, int alkuSekunnit) {
        this(-1, alkuMinuutit, alkuSekunnit);
    }

    public void aikaKuluu() {
        // testiä ajettaessa ei tarvitse odottaa eikä graafisessa
//        if (testataan == false) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Ajastin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        if (sekunnit.vahene()) {
            if (minuutit.vahene()) {
                tunnit.vahene();
            }
        }
    }
    
    public void aikaaMenee(){
        if(sekunnit.etene()){
            if(minuutit.etene()){
                tunnit.etene();
            }
        }
    }

    // keskeyttämistoiminnallisuus lisätään graafisen käyttöliittymän myötä
//    public void keskeytaAjastus() {
//        kaynnissa = false;
//    }
//
//    public void jatkaAjastusta() {
//        kaynnissa = true;
//    }
    public void alustaAjastin() {
        tunnit.arvo = alkuTunnit;
        minuutit.arvo = alkuMinuutit;
        sekunnit.arvo = alkuSekunnit;
    }

    @Override
    public String toString() {
        if (alkuTunnit == -1) {
            return minuutit.toString() + ":" + sekunnit.toString();
        }
        return tunnit.toString() + ":" + minuutit.toString() + ":" + sekunnit.toString();
    }
}
