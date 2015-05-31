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
    
    public void setStopienTrudnosci(int stopien)
    {
        this.id_stopien_trudnosci=stopien;
    }
    
    public int getStopienTrudnosci()
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
    
    public void DodajZajecia()
    {
        jdbcTemplate.update("INSERT INTO ZAJECIA (NAZWA, CZAS_TRWANIA, ID_STOPIEN_TRUDNOSCI, OPIS)" + "VALUES(?,?,?,?)",
        new Object[] { nazwa, czas_trwania, id_stopien_trudnosci, opis});
    }
    
    
    public void UsunZajecia(int id_zajecia)
    {
       jdbcTemplate.update("DELETE FROM ZAJECIA WHERE ID_ZAJECIA=?", new Object[] {id_zajecia});
    }
    
    public void EdytujZajecia(int id_zajecia, String nazwa, Time czas_trwania, int id_stopien_trudnosci, String opis)
    {
        jdbcTemplate.update("UPDATE ZAJECIA SET NAZWA=?, CZAS_TRWANIA=?, ID_STOPIEN_TRUDNOSCI=?, OPIS=? WHERE ID_ZAJECIA=?",
        new Object[] { nazwa, czas_trwania, id_stopien_trudnosci, opis, id_zajecia });
    }
    
    public List<Zajecia> WyswietlZajecia()
    {
        List<Zajecia> zajeciaa = this.jdbcTemplate.query(
        "select * from zajecia",
        new RowMapper<Zajecia>() {
                @Override
                public Zajecia mapRow(ResultSet rs, int rowNum) throws SQLException {
                Zajecia zajecia = new Zajecia();
                zajecia.id_zajecia=rs.getInt("id_zajecia");
                zajecia.setNazwa(rs.getString("nazwa"));
                zajecia.setCzasTrwania(rs.getTime("czas_trwania"));
                zajecia.setStopienTrudnosci(rs.getInt("id_stopien_trudnosci"));
                zajecia.setOpis(rs.getString("opis"));
                return zajecia;
            }
        });
        return zajeciaa;
    }  
}
