/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Zajecia;
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
public class zajeciaController {
    @Autowired
    private DataSource dataSource;
    
    @RequestMapping(value = "/zajecia.htm", method = RequestMethod.GET)
   public ModelAndView grafik() {
      ModelAndView model = new ModelAndView("zajecia");
      Zajecia zajecia = new Zajecia();
      zajecia.setDataSource(dataSource);
      List<Zajecia> zajecia_list = zajecia.WyswietlZajeciaView();
      
      model.addObject("zajeciaLista", zajecia_list);
      return model;
   }
    
}
