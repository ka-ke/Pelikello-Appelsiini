/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.CheckBox;
import javax.swing.*;
import javax.swing.WindowConstants;
/**
 *
 * @author Kasperi
 */
public class PelinAsetukset implements Runnable {

    private JFrame laatikko;
    
    @Override
    public void run() {
        
        laatikko = new JFrame("Pelin asetukset");
        laatikko.setPreferredSize(new Dimension(700, 400));

        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        laatikko.setVisible(true);
    }

    private void luoKomponentit(Container loota) {
        
        loota.setLayout(new GridLayout(4, 3));
//        BoxLayout layout = new BoxLayout(loota, BoxLayout.Y_AXIS);
//        loota.setLayout(layout);
        
        JLabel paljonkoAikaa = new JLabel("Paljonko aikaa per vuoro?");
        TextField min = new TextField("min");
        TextField sek = new TextField("sek");
        JLabel montakoPelaajaa = new JLabel("Montako pelaajaa?");
        TextField pelaajia = new TextField("0");
        JLabel asetataankoVuoro = new JLabel("Asetetaanko pelille vuororajoitinta?");
        TextField vuoroja = new TextField("0");
        JButton jatka = new JButton("Jatka");
        JLabel tyhja1 = new JLabel("");
        JLabel tyhja2 = new JLabel("");
        
        ActionListener pelaajanLisaykseen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LisaaPelaaja pelaajanLisays = new LisaaPelaaja();
                pelaajanLisays.run();
            }
        };
        jatka.addActionListener(pelaajanLisaykseen);
        
        
//        JPanel paneeli = new JPanel(new SpringLayout());        
        
        loota.add(paljonkoAikaa);
        loota.add(min);
        loota.add(sek);
        loota.add(montakoPelaajaa);
        loota.add(pelaajia);
        loota.add(tyhja1);
        loota.add(asetataankoVuoro);
        loota.add(vuoroja);
        loota.add(tyhja2);
        loota.add(jatka);
        
        laatikko.setSize(loota.getMinimumSize());
//        loota.add(paneeli);
    }
}
