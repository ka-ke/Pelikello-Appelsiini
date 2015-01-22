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
    
    public int raja;
    public int arvo;
    
    public Laskuri(int raja, int arvo){
        if(raja>0){
            this.raja = raja;
        } else {
            this.raja = 59;
        }
        
        if(arvo>this.raja){
            this.arvo = this.raja;
        } else if(arvo<0){
            this.arvo = 0;
        } else {
            this.arvo = arvo;
        }
    }
    
    public boolean etene(){
        if(arvo==raja){
            arvo=0;
            return true;
        }
        arvo++;
        return false;
    }
    
    public boolean vahene(){
        if(arvo==0){
            arvo=raja;
            return true;
        } else {
            arvo--;
            return false;
        }
    }
    
    public void setArvo(int uusiarvo){
        if(uusiarvo>this.raja){
            this.arvo = this.raja;
        } else if(uusiarvo<0){
            this.arvo = 0;
        } else {
            this.arvo = uusiarvo;
        }
    }
    
    @Override
    public String toString(){
       if(arvo<10){
           return "0"+arvo;
       }
       return ""+arvo;
    }
}
