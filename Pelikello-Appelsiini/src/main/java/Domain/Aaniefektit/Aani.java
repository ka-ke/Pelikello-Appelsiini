/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Aaniefektit;
import java.applet.Applet;
import java.applet.AudioClip;
/**
 * Ääniefekti, jonka on tarkoitus ilmoittaa pelajille ajan hupenemisesta.
 * @author Kasperi
 */
public class Aani {
    /**
     * Ääni vuoron viimeiselle 5 sekunnille.
     */
    public static final Aani aikaVahenee = new Aani("/sounds/pling.wav");
    /**
     * Ääni merkiksi vuoron päättymisestä.
     */
    public static final Aani aikaLoppui = new Aani("/sounds/pliiing.wav");
    private AudioClip raita;
    
    /**
     * 
     * @param tiedosto Toistettava ääniraita. 
     */
    public Aani(String tiedosto){
        raita = Applet.newAudioClip(Aani.class.getResource(tiedosto));
    }
    /**
     * Toistaa ääniraidan.
     */
    public void toista(){
        new Thread(){
            @Override
            public void run(){
                raita.play();
            }
        }.start();
    }
}
