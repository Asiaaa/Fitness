/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Grafik;
import Model.Grafik_fitness;
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
public class grafikController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/grafik.htm", method = RequestMethod.GET)
   public ModelAndView grafik() {
      ModelAndView model = new ModelAndView("grafik");
      Grafik_fitness grafik = new Grafik_fitness();
      grafik.setDataSource(dataSource);
      List<Grafik_fitness> grafik_list = grafik.getAll();     
      model.addObject("grafikLista", grafik_list);
      return model;
   }
   
   @RequestMapping(value = "/grafik_silownia.htm", method = RequestMethod.GET)
   public ModelAndView grafik_silownia() {
      ModelAndView model = new ModelAndView("grafik_silownia");
      Grafik grafik = new Grafik();
      grafik.setDataSource(dataSource);
      List<Grafik> grafik_list = grafik.WyswietlGrafik();
      
      model.addObject("grafikLista", grafik_list);
      return model;
   }
    
}
