/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Grafik_fitness;
import Model.Uzytkownik;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author inka
 */
@Controller
@EnableWebMvc
public class kadraController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/kadra.htm", method = RequestMethod.GET)
   public ModelAndView grafik() {
      ModelAndView model = new ModelAndView("kadra");
      Uzytkownik user = new Uzytkownik();
      Grafik_fitness grafik = new Grafik_fitness();
      grafik.setDataSource(dataSource);
      user.setDataSource(dataSource);
      List<Grafik_fitness> grafik_list = grafik.getAllKadra();
      List<Uzytkownik> user_list = user.getAllKadra();
      model.addObject("userLista", user_list);
      model.addObject("grafikLista", grafik_list);
      return model;
   }
    
}
