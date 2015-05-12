/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Joanna
 */
public class Uzytkownik {
    //public int id_uzytkownik;
    //private String login;
    //private String haslo;
    private String imie;
    private String nazwisko;
   // private String email;
    //private String telefon;
    //private String opis;
    //private String rola;
    
    public String getImie()
    {
        return this.imie;
    }
    
    public void setImie(String imie)
    {
        this.imie=imie;
    }
    
    public String getNazwisko()
    {
        return this.nazwisko;
    }
    
    public void setNazwisko(String nazwisko)
    {
        this.nazwisko=nazwisko;
    }
    
}
