/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Kasperi
 */
public class Pelaaja implements Comparable<Pelaaja> {

    public String nimi;
    public int vuoro;
    public int peliMinuutit;
    public int peliSekunnit;

    public Pelaaja(String nimi, int vuoroNumero) {

        this.nimi = nimi;
        vuoro = vuoroNumero;
        peliMinuutit = 0;
        peliSekunnit = 0;
    }

    @Override
    public int compareTo(Pelaaja verrattava) {

        if (this.vuoro == verrattava.vuoro) {

            int i = 0;
            while (this.nimi.charAt(i) == verrattava.nimi.charAt(i)) {
                i++;
            }

            if (this.nimi.charAt(i) < verrattava.nimi.charAt(i)) {
                return -1;
            } else {
                return 1;
            }
        }

        if (this.vuoro < verrattava.vuoro) {
            return -1;
        } else {
            return 1;
        }
    }
}
