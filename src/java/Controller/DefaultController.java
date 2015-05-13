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
import Model.Uzytkownik;
import Model.Mail;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/**
 *
 * @author Joanna
 */


@Controller
//@ImportResource("/WEB-INF/dispatcher-servlet.xml")
public class DefaultController extends HttpServlet {
    
    @Autowired
    private DataSource dataSource;

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
      config.getServletContext());
  }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    Uzytkownik user = new Uzytkownik();
    user.setDataSource(dataSource);
    /*List <Uzytkownik> users = 
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
        out.print("Jakies cos...");
    }*/
        try {
            //user.DodajPracownika("asia", "asia", "Joanna", "Wolna", "asia@interia.pl", "888-888-888", "Sprzataczka :P");
            //user.UsunPracownika(3);
            //user.EdytujPracownika(1, "knowakowska", "knowakowska", "Karolina", "Nowakowska", "knowakowska", "555-555-555", null);
            user.WyslijEmail("joanna.wolna@ymail.com", "Hello", "Pierwsza wiadomosc");
        } catch (MessagingException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}