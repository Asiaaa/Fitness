/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.BaseDriver;
import Model.Uzytkownik;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Joanna
 */
@Controller
public class DefaultController extends HttpServlet {
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    //out.print("Imie: ");
    BaseDriver db = new BaseDriver();
    db.setDataSource(dataSource);
    List <Uzytkownik> users = 
            db.select_user();
    if(users!=null)
    {
    for(Uzytkownik x: users)
    {
        out.println(x.getImie()+" "+x.getNazwisko());
    }
    }
    else
    {
        out.print("Jakis shit...");
    }
       
}
}