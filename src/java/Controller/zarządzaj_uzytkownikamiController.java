package Controller;

import Model.Uzytkownik;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joanna
 */
@Controller
public class zarządzaj_uzytkownikamiController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/zarzadzaj_uzytkownicy.htm", method = RequestMethod.GET)
   public String student(ModelMap model) {
       Uzytkownik user = new Uzytkownik();
       user.setDataSource(dataSource);
       model.addAttribute("users", user.WyswietlUzytkownikow());
      return "zarzadzaj_uzytkownicy";
   }
   
   @RequestMapping(value = "/edytuj_uzytkownika.htm", method = RequestMethod.GET)
   public ModelAndView edytuj(@RequestParam("id")int id) {
       Uzytkownik user = new Uzytkownik();
       user.setDataSource(dataSource);
       return new ModelAndView("edit_user", "command", user.WyswietlUzytkownika(id));
   }
   
   @RequestMapping(value = "/edytuj_uzytkownika.htm", method = RequestMethod.POST)
   public String dodaj(@RequestParam("id")int id, @ModelAttribute("SpringWeb")Uzytkownik user) {
       user.setDataSource(dataSource);
       Uzytkownik tmp = user.WyswietlUzytkownika(id);
       user.setHaslo(tmp.getHaslo());
       user.EdytujUzytkownika(id);
       user.EdytujRole(id);
       return "redirect:/zarzadzaj_uzytkownicy.htm";
   }
   
   @RequestMapping(value = "/usun_uzytkownika.htm", method = RequestMethod.GET)
   public String usun(@RequestParam("id")int id) {
       Uzytkownik user = new Uzytkownik();
       user.setDataSource(dataSource);
       user.UsunUzytkownika(id);
       return "redirect:/zarzadzaj_uzytkownicy.htm";
   }
    
}
