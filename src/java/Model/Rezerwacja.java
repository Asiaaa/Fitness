/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;
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
public class Rezerwacja {
    
    public int id_rezerwacja;
    private int id_grafik_silownia;
    private int id_grafik_fitness;
    private int id_klient;
    private Date data;
    private Time godz_start;
    private Time godz_koniec;
    private int id_typ_zajec;
    
    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
    public void setIdGrafikSilownia(int id)
    {
        this.id_grafik_silownia=id;
    }
    
    public int getIdGrafikSilownia()
    {
        return id_grafik_silownia;
    }
    
    public void setIdGrafikFitness(int id)
    {
        this.id_grafik_fitness=id;
    }
    
    public int getIdGrafikFitness()
    {
        return id_grafik_fitness;
    }
    
    public void setIdKlient(int id)
    {
        this.id_klient=id;
    }
    
    public int getIdKlient()
    {
        return id_klient;
    }
    
    public void setData(Date data)
    {
        this.data=data;
    }
    
    public Date getData()
    {
        return data;
    }
    
    public void setGodzStart(Time godz)
    {
        this.godz_start=godz;
    }
    
    public Time getGodzStart()
    {
        return godz_start;
    }
    
    public void setGodzKoniec(Time godz)
    {
        this.godz_koniec=godz;
    }
    
    public Time getGodzKoniec()
    {
        return godz_koniec;
    }
    
    public void setIdTypZajec(int id)
    {
        this.id_typ_zajec=id;
    }
    
    public int getIdTypZajec()
    {
        return id_typ_zajec;
    }
    
   public void DodajRezerwacje()
   {
       jdbcTemplate.update("INSERT INTO REZERWACJS (ID_GRAFIK_FITNESS, ID_GRAFIK_SILOWNIA, ID_KLIENT, DATA, GODZ_START"
               + "GODZ_KONIEC, ID_TYP_ZAJEC)" + "VALUES(?,?,?,?,?,?,?)",
        new Object[] {id_grafik_fitness, id_grafik_silownia, id_klient, data, godz_start, godz_koniec, id_typ_zajec });
   }
   
   public void UsunRezerwacje(int id_rezerwacja)
   {
       jdbcTemplate.update("DELETE FROM REZERWACJA WHERE ID_REZERWACJA=?", new Object[] {id_rezerwacja});
   }
}
