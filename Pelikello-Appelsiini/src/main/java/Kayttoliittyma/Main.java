/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Ajastin;

/**
 *
 * @author Kasperi
 */
public class Main {
    
    public static void main(String[] args) {

//        Kellonluonti testi = new Kellonluonti();
//        testi.luoKello();
        
        Ajastin testiKello = new Ajastin(0, 30);
        testiKello.otaAikaa();
    }
}
