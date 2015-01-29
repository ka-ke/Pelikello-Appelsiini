/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;
import Sovelluslogiikka.*;
import java.util.*;

/**
 *
 * @author Kasperi
 */
public class Peli {
    
    public int pelattujaVuoroja;
    public int vuoroRaja;
    public int vuorossa;
    boolean kaynnissa;
    boolean rajaton;
    List<Pelaaja> pelaajat;
    Ajastin ajastin;
    
    public Peli(Ajastin ajastin, List<Pelaaja> pelaajat, int vuoroja){
        pelattujaVuoroja = 0;
        vuoroRaja = vuoroja;
        this.ajastin = ajastin;
        this.pelaajat = pelaajat;
        vuorossa = 0;
        kaynnissa = true;
    }
    
    public Peli(Ajastin ajastin, List<Pelaaja> pelaajat){
        this(ajastin, pelaajat, -1);
    }
    
    public void aloitaPeli(){
        pelaaVuoro(vuorossa);
    }
    
    public void seuraavaVuoro(){
        vuorossa++;
        if(vuorossa==pelaajat.size()){
            vuorossa=0;
        }
        pelaaVuoro(vuorossa);
    }
    
    public void pelaaVuoro(int vuorossa){
        Pelaaja pelaaja = pelaajat.get(vuorossa);
        ajastin.otaAikaa();
        ajastin.alustaAjastin();
        pelattujaVuoroja++;
    }
    
    public void lopetaVuoro(){
        ajastin.keskeytaAjastus();
    }   
    
    public void lopetaPeli(){
        kaynnissa = false;
    }
}
