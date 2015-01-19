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
public class Laskuri {
    
    int raja;
    int arvo;
    
    public Laskuri(int raja, int arvo){
        this.raja = raja;
        this.arvo = arvo;
    }
    
    public void etene(){
        arvo++;
    }
    
    public boolean vahene(){
        if(arvo==0){
            arvo=59;
            return true;
        } else {
            arvo--;
            return false;
        }
    }
    
    public void nollaudu(){
        arvo=0;
    }
    
    @Override
    public String toString(){
       if(arvo<10){
           return "0"+arvo;
       }
       return ""+arvo;
    }
}
