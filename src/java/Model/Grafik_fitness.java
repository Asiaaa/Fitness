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
import java.security.Principal;

/**
 *
 * @author Joanna
 */
public class Grafik_fitness{
    private int id_instruktor;
    private int id_zajecia;
    private int id_sala;
    private int godz_start;
    private int godz_koniec;
    private int id_dzien_tygodnia;
    private String dzien_tygodnia;
    private String imie;
    private String nazwisko;
    private int max_ilosc_miejsc;
    private String zajecia;
    
    private int id_grafik_fitness;
    
    private JdbcTemplate jdbcTemplate;
    
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
    public void setIdGrafikFitness(int id){
        this.id_grafik_fitness = id;
    }
    
    public int getIdGrafikFitness(){
        return this.id_grafik_fitness;
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
    
      public void setIdInstruktor(int aInt) {
        this.id_instruktor = aInt;
    }
    
    public int getIdInstruktor(){
        return this.id_instruktor;
    }
    
    public List<Grafik_fitness> WyswietlGrafik(){
        List<Grafik_fitness> grafik = this.jdbcTemplate.query(
        "select * from fit",
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                user.setIdGrafikFitness(rs.getInt("id_grafik_fitness"));
                user.setIdZajecia(rs.getInt("id_zajecia"));
                user.setMaxIloscMiejsc(rs.getInt("max_ilosc_miejsc"));
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdInstruktor(rs.getInt("id_instruktor"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                user.setZajecia(rs.getString("nazwa"));
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                user.setDzienTygodnia(rs.getString("dzien"));
                return user;
            }
        });
        return grafik;
    }

    
    public List<Grafik_fitness> getAll(){
        List<Grafik_fitness> grafik = this.jdbcTemplate.query(
        "select gf.*, d.nazwa dzien_tygodnia from grafik_fitness_view gf, dni_tygodnia d where gf.id_dzien_tygodnia=d.id_dzien_tygodnia order by gf.nazwa",
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                user.setIdGrafikFitness(rs.getInt("id_grafik_fitness"));
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdInstruktor(rs.getInt("id_instruktor"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                user.setZajecia(rs.getString("nazwa"));
                user.setDzienTygodnia(rs.getString("dzien_tygodnia"));
                return user;
            }
        });
        return grafik;
    }
    
     public Grafik_fitness WyswietlGrafikId(int id)
    {
         Grafik_fitness grafik = (Grafik_fitness)this.jdbcTemplate.queryForObject(
        "select * from fit where id_grafik_fitness=?", new Object[] {id},
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                user.setIdGrafikFitness(rs.getInt("id_grafik_fitness"));
                user.setIdZajecia(rs.getInt("id_zajecia"));
                user.setMaxIloscMiejsc(rs.getInt("max_ilosc_miejsc"));
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdInstruktor(rs.getInt("id_instruktor"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                user.setZajecia(rs.getString("nazwa"));
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                user.setDzienTygodnia(rs.getString("dzien"));
                return user;
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
    
    public List<Grafik> PobierzInstruktorow()
    {
        List<Grafik> users = this.jdbcTemplate.query("select id_uzytkownik, imie, nazwisko from uzytkownik",
                new RowMapper<Grafik>() {
                @Override
                public Grafik mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik user = new Grafik();
                user.setIdInstruktor(rs.getInt("id_uzytkownik"));
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                return user;
            }
        });
         return users;       
    }
    
    

    public List<Grafik_fitness> getAllKadra(){
        List<Grafik_fitness> grafik = this.jdbcTemplate.query(
        "select * from grafik_fitness_view group by concat(id_instruktor, nazwa)",
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdInstruktor(rs.getInt("id_instruktor"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                user.setZajecia(rs.getString("nazwa"));
                return user;
            }
        });
        return grafik;
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
    
    public void setDzienTygodnia(String dzien)
    {
        this.dzien_tygodnia=dzien;
    }
    
    public String getDzienTygodnia()
    {
        return dzien_tygodnia;
    }
    public int getGodzStart(){
        return this.godz_start;
    }
    
    public void setImie(String imie){
        this.imie = imie;
    }
    public String getImie(){
        return this.imie;
    }
    
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
    public String getNazwisko(){
        return this.nazwisko;
    }
    
    public int getGodzKoniec(){
        return this.godz_koniec;
    }
    
    public void setZajecia(String zajecia){
        this.zajecia = zajecia;
    }
    public String getZajecia(){
        return this.zajecia;
    }
    
    
   /* public void setDzienTygodnia(String dzien){
        this.dzien_tygodnia = dzien;
    }
    public String getDzienTygodnia(){
        return this.dzien_tygodnia;
    }*/
    
    /*public void setDzienTygodnia(String dzien){
        this.dzien_tygodnia = dzien;
    }
    public String getDzienTygodnia(){
        return this.dzien_tygodnia;
    }*/
    
    public List<Grafik_fitness> wyswietlGrafikUzytkownika(String login){
        List<Grafik_fitness> grafik = this.jdbcTemplate.query(
        "select grafik_fitness_view.* from grafik_fitness_view, uzytkownik where grafik_fitness_view.id_instruktor=uzytkownik.id_uzytkownik and uzytkownik.login=?",
                new Object [] {login},
        new RowMapper<Grafik_fitness>() {
            @Override
            public Grafik_fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grafik_fitness user = new Grafik_fitness();
                
                user.setIdSala(rs.getInt("id_sala"));
                user.setIdInstruktor(rs.getInt("id_instruktor"));
                user.setGodzStart(rs.getInt("godz_start"));
                user.setGodzKoniec(rs.getInt("godz_koniec"));
                user.setIdDzienTygodnia(rs.getInt("id_dzien_tygodnia"));
                user.setZajecia(rs.getString("nazwa"));
                return user;
            }
        });
        return grafik;
    }
    
     public void EdytujGrafik(int id)
    {
        jdbcTemplate.update("UPDATE GRAFIK_FITNESS SET GODZ_START=?, GODZ_KONIEC=?, ID_DZIEN_TYGODNIA=? "
                + "WHERE ID_GRAFIK_FITNESS=?",
        new Object[] { godz_start, godz_koniec, id_dzien_tygodnia, id});
    }
     
     public void UsunGrafik(int id)
     {
         jdbcTemplate.update("DELETE FROM GRAFIK_FITNESS WHERE ID_GRAFIK_FITNESS=?", new Object[] {id});
     }
}
    
