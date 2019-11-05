package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class HomeController {
    
    @GetMapping
    public ModelAndView homePage(){
        ModelAndView mv = new ModelAndView("Home.html");
        return mv;
    }
}
