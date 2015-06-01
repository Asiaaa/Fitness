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
public class Grafik {
    public int id_grafik;
    private int id_instruktor;
    private int id_dzien_tygodnia;
    private int godz_start;
    private int godz_end;
    
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
    
    public void setGodzStart(int godz_start)
    {
        this.godz_start=godz_start;
    }
    
    public int getGodzStart()
    {
        return godz_start;
    }
    
    public void setGodzEnd(int godz_end)
    {
        this.godz_end=godz_end;
    }
    
    public int getGodzEnd()
    {
        return godz_end;
    }
    
    public void setIdDzienTygodnia(int dzien_tygodnia)
    {
        this.id_dzien_tygodnia=dzien_tygodnia;
    }
    
    public int getIdDzienTygodnia()
    {
        return id_dzien_tygodnia;
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
    
    
    public String imie;
    public void setImie(String imie){
        this.imie = imie;
    }
    public String getImie(){
        return this.imie;
    }
    
    public String nazwisko;
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
    public String getNazwisko(){
        return this.nazwisko;
    }
    
    public String dzien_tygodnia;
    public void setDzienTygodnia(String d)
    {
        this.dzien_tygodnia=d;
    }
    public String getDdzienTygodnia()
    {
        return dzien_tygodnia;
    }
    
    public int getId()
    {
       return id_grafik;
    }
 
                    
    public List<Grafik> WyswietlGrafik(){
        List<Grafik> grafik = this.jdbcTemplate.query(
        "select * from grafik_silownia_view",
        new RowMapper<Grafik>() {
            @Override
            public Grafik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik gf = new Grafik();
                gf.id_grafik=rs.getInt("id_grafik_silownia");
                gf.setDzienTygodnia(rs.getString("nazwa"));
                gf.setIdInstruktor(rs.getInt("id_uzytkownik"));
                gf.setGodzStart(rs.getInt("godz_start_dyzur"));
                gf.setGodzEnd(rs.getInt("godz_koniec_dyzur"));
                gf.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                gf.setNazwisko(rs.getString("nazwisko"));
                gf.setImie(rs.getString("imie"));
                return gf;
            }
        });
        return grafik;
    }
    
    public Grafik WyswietlGrafikId(int id)
    {
         Grafik grafik = (Grafik)this.jdbcTemplate.queryForObject(
        "select * from grafik_silownia_view where id_grafik_silownia=?", new Object[] {id},
        new RowMapper<Grafik>() {
            @Override
            public Grafik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik gf = new Grafik();
                gf.setDzienTygodnia(rs.getString("nazwa"));
                gf.setIdInstruktor(rs.getInt("id_uzytkownik"));
                gf.setGodzStart(rs.getInt("godz_start_dyzur"));
                gf.setGodzEnd(rs.getInt("godz_koniec_dyzur"));
                gf.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                gf.setNazwisko(rs.getString("nazwisko"));
                gf.setImie(rs.getString("imie"));
                return gf;
            }
        });
        return grafik;
    }
    
    public List<Grafik> PobierzDniTygodnia()
    {
        List<Grafik> grafikk = this.jdbcTemplate.query(
        "select id_dzien_tygodnia, nazwa from dni_tygodnia",
        new RowMapper<Grafik>() {
                @Override
                public Grafik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik grafik = new Grafik();
                grafik.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                grafik.setDzienTygodnia(rs.getString("nazwa"));
                return grafik;
            }
        });
        return grafikk;
    }
    
    public void EdytujGrafik(int id)
    {
        jdbcTemplate.update("UPDATE GRAFIK_SILOWNIA SET ID_DZIEN_TYGODNIA=?, GODZ_START_DYZUR=?, GODZ_KONIEC_DYZUR=? "
                + "WHERE ID_GRAFIK_SILOWNIA=?",
        new Object[] { id_dzien_tygodnia, godz_start, godz_end, id});
    }
    
    public void UsunGrafik(int id)
    {
        jdbcTemplate.update("DELETE FROM GRAFIK_SILOWNIA WHERE ID_GRAFIK_SILOWNIA=?", new Object[] {id});
    }
    
    
    
    public List<Grafik> wyswietlGrafikUzytkownika(String login){
        List<Grafik> grafik = this.jdbcTemplate.query(
        "select gs.* from grafik_silownia_view gs, uzytkownik u\n" +
        "where \n" +
        "gs.imie = u.imie and\n" +
        "gs.nazwisko = u.nazwisko and\n" +
        "u.login = ?;",
                new Object [] {login},
        new RowMapper<Grafik>() {
            @Override
            public Grafik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik user = new Grafik();
                user.setGodzStart(rs.getInt("godz_start_dyzur"));
                user.setGodzEnd(rs.getInt("godz_koniec_dyzur"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                return user;
            }
        });
        return grafik;
    }
    
}
