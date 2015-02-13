/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Kayttoliittyma.*;
import Sovelluslogiikka.*;
import Aaniefektit.*;
import Kayttoliittyma.Valikot.Kaynnistysvalikko;
/**
 *
 * @author Kasperi
 */
public class Main {

        private Aani aani;
        
        public void start(){
            init();
            new Thread((Runnable) this).start();
        }
        public void init(){
            Aani.aani1.toista();
        }
    
    public static void main(String[] args) {
        
        Kaynnistysvalikko k = new Kaynnistysvalikko();
        k.run();
        
        // /Users/Kasperi/Pelikello-Appelsiini/Pelikello-Appelsiini/src/main/resources/sounds/Blip.wav        
        
//        Lukija lukija = new Lukija();
//        PelinLuonninOhjaaja pelinLuoja = new PelinLuonninOhjaaja(lukija);
//        Peli peli = pelinLuoja.luoPeli();
//
//        PelinOhjaaja pelinOhjaus = new PelinOhjaaja(lukija, peli);
//        pelinOhjaus.pelaaPeli();
    }
}
