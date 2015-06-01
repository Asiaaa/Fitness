/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Uzytkownik;
import Model.Zajecia;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Joanna
 */
@Controller
public class zarzadzaj_zajeciamiController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/zarzadzaj_zajecia.htm", method = RequestMethod.GET)
   public String zajecia(ModelMap model) {
       Zajecia zajecia = new Zajecia();
       zajecia.setDataSource(dataSource);
       model.addAttribute("zajecia", zajecia.WyswietlZajecia());
      return "zarzadzaj_zajecia";
   }
   
   @RequestMapping(value = "/edytuj_zajecia.htm", method = RequestMethod.GET)
   public ModelAndView edytuj(@RequestParam("id")int id) {
       Zajecia zajecia = new Zajecia();
       zajecia.setDataSource(dataSource);
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("command", zajecia.WyswietlZajecia(id));
       List <Zajecia> stopnie = zajecia.PobierzStopnie();
       Map <String, String> st = new LinkedHashMap<String, String>();
       for(Zajecia tmp: stopnie)
       {
           st.put(String.valueOf(tmp.getIdStopienTrudnosci()), tmp.getStopien());
       }
       model.put("stopnie", st);
       return new ModelAndView("edit_zajecia", model);
   }
  
   
   @RequestMapping(value = "/edytuj_zajecia.htm", method = RequestMethod.POST)
   public String dodaj(@RequestParam("id")int id, @ModelAttribute("SpringWeb")Zajecia zajecia) {
       zajecia.setDataSource(dataSource);
       zajecia.EdytujZajecia(id);
       return "redirect:/zarzadzaj_zajecia.htm";
   }
   
   @RequestMapping(value = "/usun_zajecia.htm", method = RequestMethod.GET)
   public String usun(@RequestParam("id")int id) {
       Zajecia zajecia = new Zajecia();
       zajecia.setDataSource(dataSource);
       zajecia.UsunZajecia(id);
       return "redirect:/zarzadzaj_zajecia.htm";
   }
   
    /*@RequestMapping(value = "/dodaj_zajecia.htm", method = RequestMethod.GET)
   public ModelAndView dodajZajecia() {
      return new ModelAndView("add_zajecia", "command", new Zajecia());
   }*/
   
   @RequestMapping(value = "/dodaj_zajecia.htm", method = RequestMethod.GET)
   public ModelAndView dodajZajecia() {
       Zajecia zajecia = new Zajecia();
       zajecia.setDataSource(dataSource);
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("command", new Zajecia());
       List <Zajecia> stopnie = zajecia.PobierzStopnie();
       Map <String, String> st = new LinkedHashMap<String, String>();
       for(Zajecia tmp: stopnie)
       {
           st.put(String.valueOf(tmp.getIdStopienTrudnosci()), tmp.getStopien());
           System.out.println(tmp.getIdStopienTrudnosci()+"hello");
       }
       model.put("stopnie", st);
       return new ModelAndView("add_zajecia", model);
   }
   
   @RequestMapping(value = "/add_zajecia.htm", method = RequestMethod.POST)
   public String addZajecia(@ModelAttribute("SpringWeb")Zajecia zajecia, 
    final RedirectAttributes redirectAttributes) {
      zajecia.setDataSource(dataSource);
      System.out.print("hello...");
      zajecia.DodajZajecia();
      redirectAttributes.addFlashAttribute("message", "Dodano!");
      return "redirect:/zarzadzaj_zajecia.htm";
   }  
}
