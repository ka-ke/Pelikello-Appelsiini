/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Pohja kevyelle ilmoitusikkunalle, joka on vain tarkoitus lukea ja kuitata.
 *
 * @author Kasperi
 */
public class IlmoitusLoota implements Runnable {

    private JFrame ilmoitus;
    String viesti;

    /**
     * @param viesti Teksti, joka on perustelu ikkunan luomisele.
     */
    public IlmoitusLoota(String viesti) {
        this.viesti = viesti;
    }

    @Override
    public void run() {

        ilmoitus = new JFrame("Ilmoitus");
        ilmoitus.setPreferredSize(new Dimension(200, 150));

        luoKomponentit(ilmoitus.getContentPane());

        ilmoitus.pack();
        ilmoitus.setVisible(false);
    }

    /**
     * Asettaa ikkunan sisällön sekä toiminnallisuuden poistumista varten.
     */
    private void luoKomponentit(Container loota) {

        loota.setLayout(new GridLayout(2, 1));
        JLabel virheViesti = new JLabel(viesti);
        JButton virheOk = new JButton("OK");
        ActionListener ok = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ilmoitus.setVisible(false);
            }
        };
        virheOk.addActionListener(ok);

        loota.add(virheViesti);
        loota.add(virheOk);
    }

    public void piilota(boolean b) {
        ilmoitus.setVisible(b);
    }

    public boolean nakyy() {
        return ilmoitus.isVisible();
    }
}
