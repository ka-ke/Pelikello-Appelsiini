/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import Kayttoliittyma.GUI.Kuuntelijat.*;
import Domain.Ajastin;
import Kayttoliittyma.GUIOhjain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Ajanottoikkuna ja siihen liittyvä toiminallisuus.
 *
 * @author Kasperi
 */
public class Ajanotto implements Runnable {

    private JFrame laatikko;
    private Timer laukaisin;
    private Ajastin ajastin = new Ajastin(0, 0);
    private ArrayList<String> ajat;

    @Override
    public void run() {
        ajat = new ArrayList();

        laatikko = new JFrame("Ajanotto");
        laatikko.setPreferredSize(new Dimension(500, 500));
        luoKomponentit(laatikko.getContentPane());

        laatikko.pack();
        nayta(true);
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(2, 1));
        JPanel ylaosa = new JPanel();
        JPanel alaosa = new JPanel();
        ylaosa.setLayout(new GridLayout(1, 1));
        alaosa.setLayout(new GridLayout(2, 2));

        JLabel kuluvaAika = new JLabel(ajastin.toString(), JLabel.CENTER);
        kuluvaAika.setFont(new Font("Serif", Font.BOLD, 100));
        JButton stop = new JButton("Pysäytä/jatka");
        JButton nollaa = new JButton("Nollaa");
        JButton tallenna = new JButton("Tallenna aika");
        JButton lopeta = new JButton("Lopeta ajanotto ja näytä tulokset");

        laukaisin = new Timer(1000, new AjanotonPaivitin(kuluvaAika, ajastin));
        Pysaytin pysaytin = new Pysaytin(laukaisin);
        Nollaaja nollaaja = new Nollaaja(ajastin, kuluvaAika, laukaisin);

        tallenna.addActionListener(new AjanTallennus(ajat, ajastin));
        nollaa.addActionListener(nollaaja);
        nollaa.addActionListener(pysaytin);
        stop.addActionListener(pysaytin);

        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIOhjain.lopetaAjanotto(ajat);
            }
        });

        ylaosa.add(kuluvaAika);
        alaosa.add(stop);
        alaosa.add(nollaa);
        alaosa.add(tallenna);
        alaosa.add(lopeta);

        loota.add(ylaosa);
        loota.add(alaosa);
    }

    /**
     * GUIOhjaimen käyttämä luokka Ajanotto-ikkunan näkyvyyden määrittämiseksi.
     *
     * @param nakyy true jos näkyy, false mikäli ei.
     */
    public void nayta(boolean nakyy) {
        laatikko.setVisible(nakyy);
    }
}
