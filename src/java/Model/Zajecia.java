/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Joanna
 */
public class Zajecia {
    
    public int id_zajecia;
    private String nazwa;
    private Time czas_trwania;
    private int id_stopien_trudnosci;
    private String opis;
    private String stopien_trudnosci;
    private String stopien;
    
    
    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
    public void setNazwa(String nazwa)
    {
        this.nazwa=nazwa;
    }
    
    public String getNazwa()
    {
        return nazwa;
    }
    
    public void setCzasTrwania(Time czas)
    {
        this.czas_trwania=czas;
    }
    
    public Time getCzasTrwania()
    {
        return czas_trwania;
    }
    
    public void setIdStopienTrudnosci(int stopien)
    {
        this.id_stopien_trudnosci=stopien;
    }
    
    public int getIdStopienTrudnosci()
    {
        return id_stopien_trudnosci;
    }
    
    public void setOpis(String opis)
    {
        this.opis=opis;
    }
    
    public String getOpis()
    {
        return opis;
    }
    
    public void setIdZajecia(int Id){
        this.id_zajecia=Id;
    }
    public int getIdZajecia(){
        return this.id_zajecia;
    }
    
    public void setStopienTrudnosci(int st){
        this.id_stopien_trudnosci=st;
    }
    public int getStopienTrudnosci(){
        return this.id_stopien_trudnosci;
    }
    
    public void setStopien(String stopien)
    {
        this.stopien=stopien;
    }
    
    public String getStopien()
    {
        return stopien;
    }
    
    public int getId()
    {
        return id_zajecia;
    }
    
    public void DodajZajecia()
    {
        jdbcTemplate.update("INSERT INTO ZAJECIA (NAZWA, CZAS_TRWANIA, ID_STOPIEN_TRUDNOSCI, OPIS)" + "VALUES(?,?,?,?)",
        new Object[] { nazwa, czas_trwania, id_stopien_trudnosci, opis});
    }
    
    
    public void UsunZajecia(int id_zajecia)
    {
       jdbcTemplate.update("DELETE FROM ZAJECIA WHERE ID_ZAJECIA=?", new Object[] {id_zajecia});
    }
    
    public void EdytujZajecia(int id_zajecia)
    {
        jdbcTemplate.update("UPDATE ZAJECIA SET NAZWA=?, CZAS_TRWANIA=?, ID_STOPIEN_TRUDNOSCI=?, OPIS=? WHERE ID_ZAJECIA=?",
        new Object[] { nazwa, czas_trwania, id_stopien_trudnosci, opis, id_zajecia });
    }
    
    
    public List<Zajecia> WyswietlZajecia()
    {
        List<Zajecia> zajeciaa = this.jdbcTemplate.query(
        "select z.*, s.nazwa from zajecia z inner join stopien_trudnosci s on s.id_stopien_trudnosci=z.id_stopien_trudnosci",
        new RowMapper<Zajecia>() {
                @Override
                public Zajecia mapRow(ResultSet rs, int rowNum) throws SQLException {
                Zajecia zajecia = new Zajecia();
                zajecia.id_zajecia=rs.getInt("id_zajecia");
                zajecia.setNazwa(rs.getString("z.nazwa"));
                zajecia.setCzasTrwania(rs.getTime("czas_trwania"));
                zajecia.setStopien(rs.getString("s.nazwa"));
                zajecia.setOpis(rs.getString("opis"));
                return zajecia;
            }
        });
        return zajeciaa;
    } 
    
    public List<Zajecia> PobierzStopnie()
    {
        List<Zajecia> zajeciaa = this.jdbcTemplate.query(
        "select id_stopien_trudnosci, nazwa from stopien_trudnosci",
        new RowMapper<Zajecia>() {
                @Override
                public Zajecia mapRow(ResultSet rs, int rowNum) throws SQLException {
                Zajecia zajecia = new Zajecia();
                zajecia.setStopienTrudnosci(rs.getInt("id_stopien_trudnosci"));
                zajecia.setStopien(rs.getString("nazwa"));
                return zajecia;
            }
        });
        return zajeciaa;
    }
    
    public List<Zajecia> WyswietlZajeciaView()
    {
        List<Zajecia> zajeciaa = this.jdbcTemplate.query(
        "select * from zajecia_view",
        new RowMapper<Zajecia>() {
                @Override
                public Zajecia mapRow(ResultSet rs, int rowNum) throws SQLException {
                Zajecia zajecia = new Zajecia();
                zajecia.id_zajecia=rs.getInt("id_zajecia");
                zajecia.setNazwa(rs.getString("nazwa"));
                zajecia.setCzasTrwania(rs.getTime("czas_trwania"));
                zajecia.setStopien(rs.getString("stopien_trudnosci"));
                zajecia.setOpis(rs.getString("opis"));
                return zajecia;
            }
        });
        return zajeciaa;
    } 
    
    public Zajecia WyswietlZajecia(int id)
    {
         Zajecia zajecia = (Zajecia)this.jdbcTemplate.queryForObject(
        "select z.*, s.nazwa from zajecia z inner join stopien_trudnosci s on s.id_stopien_trudnosci=z.id_stopien_trudnosci"
                + " where id_zajecia=?", new Object[] {id},
        new RowMapper<Zajecia>() {
            @Override
            public Zajecia mapRow(ResultSet rs, int rowNum) throws SQLException {
                Zajecia zajecia = new Zajecia();
                zajecia.id_zajecia=rs.getInt("id_zajecia");
                zajecia.setNazwa(rs.getString("z.nazwa"));
                zajecia.setCzasTrwania(rs.getTime("czas_trwania"));
                zajecia.setStopien(rs.getString("s.nazwa"));
                zajecia.setOpis(rs.getString("opis"));
                return zajecia;
            }
        });
         return zajecia;
    }
}
