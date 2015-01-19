/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Kasperi
 */
public class Ajastin {
    
    Laskuri minuutit;
    Laskuri sekunnit;
    
    public Ajastin(int alkuMinuutit, int alkuSekunnit){
        
        minuutit = new Laskuri(59, alkuMinuutit);
        sekunnit = new Laskuri(59, alkuSekunnit);
    }
    
    public void otaAikaa(){
        
        while(minuutit.arvo!=0 && sekunnit.arvo!=0){
            System.out.println(this.toString());
//            Thread.sleep(1000);
            sekunnit.vahene();
            if(sekunnit.vahene()){
                minuutit.vahene();
            }
        }
    }
    
    @Override
    public String toString(){
        return minuutit.toString()+":"+sekunnit.toString();
    }    
}
