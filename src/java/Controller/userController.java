/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Grafik_fitness;
import Model.Rezerwacja;
import java.security.Principal;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author inka
 */
@Controller
public class userController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/user_rezerwacja.htm", method = RequestMethod.GET)
   public ModelAndView grafik(Principal principal) {
      ModelAndView model = new ModelAndView("user_rezerwacja");
      Grafik_fitness grafik = new Grafik_fitness();
      Rezerwacja rezerwacja = new Rezerwacja();
      grafik.setDataSource(dataSource);
      rezerwacja.setDataSource(dataSource);
      List<Grafik_fitness> grafik_list = grafik.getAll();  
      List<Rezerwacja> rezerwacja_list = rezerwacja.wyswietlRezerwacje(principal.getName());
      model.addObject("grafikLista", grafik_list);
      model.addObject("command", new Rezerwacja());
      model.addObject("rezerwacjaLista", rezerwacja_list);
      return model;
   }
   
   @RequestMapping(value = "/user_rezerwacja.htm", method = RequestMethod.POST)
   public String addGrafik(Principal principal, @ModelAttribute("SpringWeb")Rezerwacja user, 
    final RedirectAttributes redirectAttributes) {
      user.setDataSource(dataSource);
      user.DodajRezerwacje(principal.getName());
      redirectAttributes.addFlashAttribute("message", "Dodano rezerwację");
      return "redirect:/user_rezerwacja.htm";
   }
   
   @RequestMapping(value = "/user_rezerwacja_usun.htm", method = RequestMethod.GET)
   public String usun(@RequestParam("id")int id) {
       Rezerwacja rez = new Rezerwacja();
       rez.setDataSource(dataSource);
       rez.UsunRezerwacje(id);
       return "redirect:/user_rezerwacja.htm";
   }
   
}