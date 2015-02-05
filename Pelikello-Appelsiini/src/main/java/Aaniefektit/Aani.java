/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aaniefektit;
import java.applet.Applet;
import java.applet.AudioClip;
/**
 *
 * @author Kasperi
 */
public class Aani {
    
    public static final Aani aani1 = new Aani("/Users/Kasperi/Pelikello-Appelsiini/Pelikello-Appelsiini/src/main/resources/sounds/Blip.wav");
    AudioClip raita;
    
    public Aani(String tiedosto){
        raita = Applet.newAudioClip(Aani.class.getResource(tiedosto));
    }
    
    public void toista(){
        new Thread(){
            @Override
            public void run(){
                raita.play();
            }
        }.start();
    }
}
