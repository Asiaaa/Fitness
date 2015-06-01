/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Grafik;
import Model.Grafik_fitness;
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

/**
 *
 * @author Joanna
 */
@Controller
public class grafik_fitnessController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/zarzadzaj_grafik_fitness.htm", method = RequestMethod.GET)
   public String student(ModelMap model) {
       Grafik_fitness gf = new Grafik_fitness();
       gf.setDataSource(dataSource);
       model.addAttribute("grafikf", gf.WyswietlGrafik());
      return "zarzadzaj_grafik_fitness";
   }
   
   @RequestMapping(value = "/edytuj_grafik_fitness.htm", method = RequestMethod.GET)
   public ModelAndView edytuj(@RequestParam("id")int id) {
       Grafik_fitness grafik = new Grafik_fitness();
       grafik.setDataSource(dataSource);
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("command", grafik.WyswietlGrafikId(id));
       List <Grafik> dni = grafik.PobierzDniTygodnia();
       List <Grafik> users = grafik.PobierzInstruktorow();
       Map <String, String> st = new LinkedHashMap<String, String>();
       for(Grafik tmp: dni)
       {
           st.put(String.valueOf(tmp.getIdDzienTygodnia()), tmp.getDdzienTygodnia());
       }
      /* Map <String, String> mt = new LinkedHashMap<String, String>();
       for(Grafik tmp: users)
       {
          st.put(String.valueOf(tmp.getIdInstruktor()), tmp.getNazwisko());
       }*/
       model.put("dni", st);
      // model.put("instr", mt);
       return new ModelAndView("edit_grafik_fitness", model);
   }
  
   
   @RequestMapping(value = "/edytuj_grafik_fitness.htm", method = RequestMethod.POST)
   public String dodaj(@RequestParam("id")int id, @ModelAttribute("SpringWeb")Grafik_fitness grafik) {
       grafik.setDataSource(dataSource);
       grafik.EdytujGrafik(id);
       return "redirect:/zarzadzaj_grafik_fitness.htm";
   }
   
   @RequestMapping(value = "/usun_grafik_fitness.htm", method = RequestMethod.GET)
   public String usun(@RequestParam("id")int id) {
       Grafik_fitness grafik = new Grafik_fitness();
       grafik.setDataSource(dataSource);
       grafik.UsunGrafik(id);
       return "redirect:/zarzadzaj_grafik_fitness.htm";
   }
}
