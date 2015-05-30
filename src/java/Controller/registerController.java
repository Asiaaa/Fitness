/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Uzytkownik;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joanna
 */
@Controller
public class registerController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("register", "command", new Uzytkownik());
   }
   
   @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Uzytkownik user, 
   ModelMap model) {
      model.addAttribute("command", user);
      user.setDataSource(dataSource);
      user.rejestracja();
      
      //return "register";
      return "redirect:/login.htm";
   }
    
}
