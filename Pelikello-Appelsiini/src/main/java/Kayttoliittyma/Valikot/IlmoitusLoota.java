/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Kasperi
 */
public class IlmoitusLoota implements Runnable {

    private JFrame virhe;
    String viesti;

    public IlmoitusLoota(String viesti) {
        this.viesti = viesti;
    }

    @Override
    public void run() {

        virhe = new JFrame("Virheilmoitus");
        virhe.setPreferredSize(new Dimension(200, 150));

        luoKomponentit(virhe.getContentPane());

        virhe.pack();
        virhe.setVisible(false);
    }

    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(2, 1));
        JLabel virheViesti = new JLabel(viesti);
        JButton virheOk = new JButton("OK");
        ActionListener ok = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                virhe.setVisible(false);
            }
        };
        virheOk.addActionListener(ok);

        loota.add(virheViesti);
        loota.add(virheOk);
    }

    public void setVisible(boolean b) {
        virhe.setVisible(b);
    }

    boolean getVisible() {
        return virhe.isVisible();
    }
}
