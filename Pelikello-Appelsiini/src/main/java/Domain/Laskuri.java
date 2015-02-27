/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 * Luokka, joka ylläpitää ylhäältä vapaasti valitusta sekä alhaalta nollasta
 * rajoitettua laskuria.
 *
 * @author Kasperi
 */
public class Laskuri {

    /**
     * Suurin mahdollinen arvo.
     */
    public int raja;
    /**
     * Tämän hetkinen arvo.
     */
    public int arvo;

    /**
     * Jos arvo asetetaan suuremmaksi kuin raja, se asettuu automaattisesti
     * rajaan.
     *
     * @param raja Laskurin positiivinen yläraja.
     * @param arvo Positiivnen lukuarvo, josta laskuri lähtee liikkeelle.
     */
    public Laskuri(int raja, int arvo) {
        if (raja > 0) {
            this.raja = raja;
        }

        if (arvo > this.raja) {
            this.arvo = this.raja;
        } else if (arvo > 0) {
            this.arvo = arvo;
        }
    }

    /**
     * Metodi kasvattaa arvoa yhdellä. Jos arvo menisi yli rajan, asetetaan
     * siihen sen sijaan nolla, eli arvo "pyörähtää kierroksen ympäri".
     *
     * @return True, jos arvo pyörähti ympäri, false jos ei.
     */
    public boolean etene() {
        if (arvo == raja) {
            arvo = 0;
            return true;
        }
        arvo++;
        return false;
    }

    /**
     * Metodi vahentaa arvoa yhdellä. Jos arvo menisi negatiiviseksi, asetetaan
     * siihen sen sijaan raja, eli arvo "pyörähtää kierroksen ympäri".
     *
     * @return True, jos arvo pyörähti ympäri, false jos ei.
     */
    public boolean vahene() {
        if (arvo == 0) {
            arvo = raja;
            return true;
        } else {
            arvo--;
            return false;
        }
    }

    /**
     * Metodin avulla laskurin arvon voi asettaa tarvittaessa mihin tahansa
     * lukuarvoon nollan ja rajan välillä. Jos arvoksi asettaa rajaa suuremman
     * arvon, tulee uudeksi arvoksi raja. Negatiivisilla arvoilla arvo ei muutu.
     *
     * @param uusiarvo arvoksi asetettava luku
     */
    public void setArvo(int uusiarvo) {
        if (uusiarvo > this.raja) {
            this.arvo = this.raja;
        } else if (uusiarvo < 0) {
            this.arvo = 0;
        } else {
            this.arvo = uusiarvo;
        }
    }

    /**
     * Luokkaa edustava merkkijono, joka muistuttaa digitaalisen kellon
     * esitysmuotoa.
     *
     * @return Jos arvo on alle 10, lisätään nolla eteen. Muulloin palautetaan
     * arvo.
     */
    @Override
    public String toString() {
        if (arvo < 10) {
            return "0" + arvo;
        }
        return "" + arvo;
    }
}
