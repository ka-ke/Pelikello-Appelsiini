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
public class Pelaaja implements Comparable<Pelaaja> {
    
    public String nimi;
    public int vuoro;
    
    public Pelaaja(String nimi, int vuoroNumero){
        
        this.nimi = nimi;
        vuoro = vuoroNumero;
    }   

    @Override
    public int compareTo(Pelaaja verrattava) {
        if(this.vuoro<verrattava.vuoro){
            return -1;
        } else {
            return 1;
        }
    }
}
