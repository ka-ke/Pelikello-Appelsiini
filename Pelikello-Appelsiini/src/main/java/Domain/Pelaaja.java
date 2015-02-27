/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 * Pelaaja esittää yhtä sen hetken käyttäjistä.
 *
 * @author Kasperi
 */
public class Pelaaja implements Comparable<Pelaaja> {

    public String nimi;
    public int vuoro;
    public Ajastin peliAika;

    /**
     * Konstruktorissa luodaan myös ajastin, joka mittaa kaikilla vuoroilla
     * yhteensä käytettyä peliaikaa.
     *
     * @param nimi Asetetaan merkkijono, joka edustaa pelaajaa
     * käyttöliittymässä.
     * @param vuoroNumero Jatkoa varten hyödyllinen vertailtava lukuarvo.
     * Käytännössä järjestysnumerot määräytyvät automaattisesti.
     */
    public Pelaaja(String nimi, int vuoroNumero) {

        this.nimi = nimi;
        vuoro = vuoroNumero;
        peliAika = new Ajastin(0, 0, 0);
    }

    /**
     * Vertailee pelaajia järjestysnumeroiden perusteella.
     *
     * @param verrattava Pelaaja johon tätä pelaajaa verrataan.
     * @return Pienemmän vuoronumeron pelaaja päätyy järjestyksessä
     * ensimmäiseksi. Tasatilanteessa nimien aakkosjärjestys ratkaisee.
     */
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

    /**
     * @return Palauttaa kaikilla vuoroilla yhteensä käytetyn peliajan
     * digitaaliesityksenä.
     */
    public String getPeliAika() {
        return peliAika.tunnit.toString() + ":"
                + peliAika.minuutit.toString() + ":" + peliAika.sekunnit.toString();
    }
}
