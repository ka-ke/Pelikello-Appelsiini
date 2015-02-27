/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.GUI.Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Kuuntelija, joka sulkee ikkunan, joka sitä kutsuu.
 *
 * @author Kasperi
 */
public class IkkunanSulkija implements ActionListener {

    private JFrame ikkuna;

    /**
     *
     * @param ikkuna Suljettava ikkuna.
     */
    public IkkunanSulkija(JFrame ikkuna) {
        this.ikkuna = ikkuna;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ikkuna.setVisible(false);
    }
}
