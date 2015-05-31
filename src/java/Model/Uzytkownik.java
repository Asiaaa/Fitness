/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.mail.MessagingException;

/**
 *
 * @author Joanna
 */
public class Uzytkownik {
    public int id_uzytkownik;
    private String login;
    private String haslo; // niehashowane
    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private String rola;
    
    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
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
    
    public void setLogin(String login)
    {
        this.login=login;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public void setHaslo(String haslo)
    {
        this.haslo=haslo;
    }
    
    public String getHaslo()
    {
        return null; // ????
    }
    
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setTelefon(String telefon)
    {
        this.telefon=telefon;
    }
    
    public String getTelefon()
    {
        return this.telefon;
    }
   
    
    public void setRola(String rola)
    {
        this.rola=rola;
    }
    
    public String getRola()
    {
        return this.rola;
    }
    
    public void setIdUzytkownik(int id_uzytkownik){
        this.id_uzytkownik = id_uzytkownik;
    }
    
    public int getIdUzytkownik(){
        return this.id_uzytkownik;
    }
    public void DodajPracownika(String login, String haslo, String imie, String nazwisko, String email, String telefon)
    {
        jdbcTemplate.update("INSERT INTO UZYTKOWNIK (LOGIN, HASLO, IMIE, NAZWISKO, EMAIL, TELEFON, OPIS, ROLA)" + "VALUES(?,?,?,?,?,?,?,?)",
        new Object[] { login, haslo, imie, nazwisko, email, telefon, null, "pracownik" });
    }
    
    public void UsunPracownika(int id_pracownik)
    {
        jdbcTemplate.update("DELETE FROM UZYTKOWNIK WHERE ID_UZYTKOWNIK=?", new Object[] {id_pracownik});
    }
    
    public void EdytujPracownika(int id_pracownik, String login, String haslo, String imie, String nazwisko, String email, String telefon)
    {
        jdbcTemplate.update("UPDATE UZYTKOWNIK SET LOGIN=?, HASLO=?, IMIE=?, NAZWISKO=?, EMAIL=?, TELEFON=?, OPIS=? WHERE ID_UZYTKOWNIK=?",
        new Object[] { login, haslo, imie, nazwisko, email, telefon, null, id_pracownik });
    }
    
    public void UsunKlienta(int id_klient)
    {
        jdbcTemplate.update("DELETE FROM UZYTKOWNIK WHERE ID_UZYTKOWNIK=?", new Object[] {id_klient});
    }
    
    public void WyswietlDane()
    {
        // uzycie f-cji get
    }
    
    public void rejestracja()
    {
        jdbcTemplate.update("call rejestracja(?,?,?,?,?,?)",
        new Object[] { login, haslo, imie, nazwisko, email, telefon});
    }
    
    /*public List<Grafik> WyswietlGrafik()
    {
        
    }*/
    
    public void WyslijEmail(String temat, String wiadomosc, String adresat) throws MessagingException
    {
        Mail message = new Mail(adresat, temat, wiadomosc);
        message.send();
    } 
 
    
    public List<Uzytkownik> select_users_base_test() // testowe - wyswietla wszystkich uzytkownikow
    {
        List<Uzytkownik> users = this.jdbcTemplate.query(
        "select imie, nazwisko from uzytkownik",
        new RowMapper<Uzytkownik>() {
            @Override
            public Uzytkownik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Uzytkownik user = new Uzytkownik();
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                return user;
            }
        });
        return users;
    }
    
    public List<Uzytkownik> getAllKadra(){
        List<Uzytkownik> users = this.jdbcTemplate.query(
        "select imie, nazwisko, id_uzytkownik from uzytkownik where id_rola=2",
        new RowMapper<Uzytkownik>() {
            @Override
            public Uzytkownik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Uzytkownik user = new Uzytkownik();
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                user.setIdUzytkownik(rs.getInt("id_uzytkownik"));
                return user;
            }
        });
        return users;
    } 
    
    
}
