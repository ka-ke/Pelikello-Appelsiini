/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;

import java.util.Scanner;

/**
 * Tekstikäyttöliittymässä käyttäjän syöteen lukija. Ei enää käytössä GUI:n valmistuttua.
 * @author Kasperi
 */
public class Lukija {

    Scanner lukija;

    public Lukija() {
        lukija = new Scanner(System.in);
    }

    public int lueLuku() {
        int luettava;
        while (true) {
            try {
                luettava = Integer.parseInt(lukija.nextLine());
                break;
            } catch (Exception e) {
                virheViestiLuvut();
            }
        }
        return luettava;
    }

    public String lueRivi() {
        String luettava;
        while (true) {
            try {
                luettava = lukija.nextLine();
                break;
            } catch (Exception e) {
                virheViestiMerkit();
            }
        }
        return luettava;
    }

    public void virheViestiLuvut() {
        System.out.println("Et syöttänyt ohjeiden mukaista lukua, vastaa uudestaan.");
    }

    public void virheViestiMerkit() {
        System.out.println("Et syöttänyt ohjeiden mukaista merkkijonoa, vastaa uudestaan.");
    }
}
