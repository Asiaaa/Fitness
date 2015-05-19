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
public class Instruktor extends Uzytkownik {
    private String opis;
    
    public void setOpis(String opis)
    {
        this.opis=opis;
    }
    
    public String getOpis()
    {
        return opis;
    }
    
    public void DodajInstruktora(String login, String haslo, String imie, String nazwisko, String email, String telefon, String opis)
    {
        jdbcTemplate.update("INSERT INTO UZYTKOWNIK (LOGIN, HASLO, IMIE, NAZWISKO, EMAIL, TELEFON, OPIS, ROLA)" + "VALUES(?,?,?,?,?,?,?,?)",
        new Object[] { login, haslo, imie, nazwisko, email, telefon, opis, "instruktor" });
    }
    
    public void EdytujInstrutora(int id_instruktor, String login, String haslo, String imie, String nazwisko, String email, String telefon,
            String opis)
    {
        jdbcTemplate.update("UPDATE UZYTKOWNIK SET LOGIN=?, HASLO=?, IMIE=?, NAZWISKO=?, EMAIL=?, TELEFON=?, OPIS=? WHERE ID_UZYTKOWNIK=?",
        new Object[] { login, haslo, imie, nazwisko, email, telefon, opis, id_instruktor });
    }
    
    public void UsunInstruktora(int id_instruktor)
    {
        jdbcTemplate.update("DELETE FROM UZYTKOWNIK WHERE ID_UZYTKOWNIK=?", new Object[] {id_instruktor});
    }
    
    public void EdytujOpis(String opis)
    {
        this.setOpis(opis);
    }
    
    public void DodajZdjecie()
    {
        // zdjecie? :P
    }
    
}
