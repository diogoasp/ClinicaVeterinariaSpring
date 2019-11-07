package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/sobre")
public class SobreController {
    
    @GetMapping
    public ModelAndView aboutPage(){
        ModelAndView mv = new ModelAndView("About.html");
        return mv;
    }
}
