/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Time;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Joanna
 */
public class Grafik {
    public int id_grafik;
    private int id_instruktor;
    private int id_dzien_tygodnia;
    private Time godz_start;
    private Time godz_end;
    
    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;
     
    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
    public void setIdInstruktor(int id_instruktor)
    {
        this.id_instruktor=id_instruktor;
    }
    
    public int getIdInstruktor()
    {
       return id_instruktor;
    }
    
    public void setGodzStart(Time godz_start)
    {
        this.godz_start=godz_start;
    }
    
    public Time getGodzStart()
    {
        return godz_start;
    }
    
    public void setGodzEnd(Time godz_end)
    {
        this.godz_end=godz_end;
    }
    
    public Time getGodzEnd()
    {
        return godz_end;
    }
    
    public void setIdDzienTygodnia(int dzien_tygodnia)
    {
        this.id_dzien_tygodnia=dzien_tygodnia;
    }
    
    public int getDzienTygodnia()
    {
        return id_dzien_tygodnia;
    }
    
 /* public void DodajDyzur(int id_instruktor, Time godz_start, Time godz_end, int id_dzien_tygodnia)
   {
       int id=0;
       jdbcTemplate.update("INSERT INTO GRAFIK_SILOWNIA (ID_DZIEN_TYGIDNIA, GODZ_START_DYZUR, GODZ_KONIEC_DYZUR)" + "VALUES(?,?,?)",
       new Object[] { id_dzien_tygodnia, godz_start, godz_end});
       id=jdbcTemplate.queryForInt("SELECT MAX(ID_GRAFIK_SILOWNIA) FROM GRAFIK_SILOWNIA");
       jdbcTemplate.update("INSERT INTO INSTRUKTOR_SILOWNIA (ID_INSTRUKTOR, ID_GRAFIK_SILOWNIA)" + "VALUES(?,?)", 
       new Object[] { id_instruktor, id});
       
   }
    */
    
}
