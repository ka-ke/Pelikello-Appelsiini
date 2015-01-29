/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma.Tekstikayttoliittymat;
import Kayttoliittyma.Lukija;
import Sovelluslogiikka.Ajastin;
/**
 *
 * @author Kasperi
 */
public class KellonLuonti {
    
    Lukija lukija;
    
    public KellonLuonti(){
        lukija = new Lukija();
    }
    
    public Ajastin luoKello(){
        
        System.out.println("Paljonko aikaa per vuoro?");
        System.out.println("Syötä ensin minuutit ja sitten sekuntit enterillä eroteltuna");
        
        int minuuttejaVuorossa = lukija.lueLuku();
        int sekuntejaVuorossa = lukija.lueLuku();
        
        Ajastin ajastin = new Ajastin(minuuttejaVuorossa, sekuntejaVuorossa);
        
        System.out.println("Pelaajalla on aikaa per vuoro "+ajastin.minuutit+" minuuttia ja "
                +ajastin.sekunnit+" sekuntia.");
 
        return new Ajastin(minuuttejaVuorossa, sekuntejaVuorossa);
    }
}
