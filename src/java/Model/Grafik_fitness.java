/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Joanna
 */
public class Grafik_fitness {
    private int id_instruktor;
    private int id_zajecia;
    private int id_sala;
    private int godz_start;
    private int godz_koniec;
    private int id_dzien_tygodnia;
    private int max_ilosc_miejsc;
    private String zajecia;
    
    private int id_grafik_fitness;
    
    private JdbcTemplate jdbcTemplate;
    
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
   
    public void setIdZajecia(int id_zajecia)
    {
        this.id_zajecia=id_zajecia;
    }
    
    public int getIdZajecia()
    {
        return id_zajecia;
    }
    
    public void setIdSala(int id_sala)
    {
        this.id_sala=id_sala;
    }
    
    public int getIdSala()
    {
        return id_sala;
    }
    
    public void setMaxIloscMiejsc(int max_ilosc_miejsc)
    {
        this.max_ilosc_miejsc=max_ilosc_miejsc;
    }
    
    public int getMaxIloscMiejsc()
    {
        return max_ilosc_miejsc;
    }
    
    public List<Grafik_fitness> getAll(){
        List<Grafik_fitness> grafik = this.jdbcTemplate.query(
        "select * from grafik_fitness",
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdZajecia(rs.getInt("id_zajecia"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                return user;
            }
        });
        return grafik;
    }

    public void setIdInstruktor(int aInt) {
        this.id_instruktor = aInt;
    }
    
    public int getIdInstruktor(){
        return this.id_instruktor;
    }

    public void setGodzStart(int aInt) {
        this.godz_start = aInt;
    }
    
    public void setGodzKoniec(int aInt){
        this.godz_koniec = aInt;
    }
    
    public void setIdDzienTygodnia(int aInt){
        this.id_dzien_tygodnia = aInt;
    }
    
    public int getIdDzienTygodnia(){
        return this.id_dzien_tygodnia;
    }
    
    public int getGodzStart(){
        return this.godz_start;
    }
    
    public int getGodzKoniec(){
        return this.godz_koniec;
    }
    
}
    
