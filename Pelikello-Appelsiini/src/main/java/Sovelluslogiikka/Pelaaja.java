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
    public Ajastin peliAika;

    public Pelaaja(String nimi, int vuoroNumero) {

        this.nimi = nimi;
        vuoro = vuoroNumero;
        peliAika = new Ajastin(0,0);
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
    
    public String getPeliAika(){
        if (peliAika.alkuTunnit == -1) {
            return peliAika.minuutit.toString() + ":" + peliAika.sekunnit.toString();
        }
        return peliAika.tunnit.toString() + ":" + 
                peliAika.minuutit.toString() + ":" + peliAika.sekunnit.toString();
    }
}
