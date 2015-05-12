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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Joanna
 */
public class BaseDriver {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Uzytkownik> select_user()
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
    
   /* public void setDatasource(DataSource datasource)
    {
        this.datasource=datasource;
    }
    
    public void setQuery(String query)
    {
        this.query=query;
    }
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public List<Uzytkownik> select()
    {
    try 
    {
    preparedStatement = connection.prepareStatement("SELECT IMIE, NAZWISKO FROM UZYTKWNIK");
    resultSet = preparedStatement.executeQuery();
    List <Uzytkownik> users = new ArrayList <Uzytkownik>();
    users=null;
    if(resultSet.next())
    {
    Uzytkownik user = new Uzytkownik();
    user.setImie(resultSet.getString("IMIE"));
    user.setNazwisko(resultSet.getString("NAZWISKO"));
    users.add(user);
    }
    }catch (SQLException e)
    {
        e.printStackTrace();
        return null;
    } 
       return users;
            
    }*/
}
