/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
/**
 *
 * @author Kasperi
 */
public class Lukija {
    
    Scanner lukija;
    
    public Lukija(){
        lukija = new Scanner(System.in);
    }
    
    public String lueRivi(){
        return lukija.nextLine();
    }
    
    public int lueLuku(){
        return lukija.nextInt();
    }
    
    public String lueSana(){
        return lukija.next();
    }
}
