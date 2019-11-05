package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.trabalho.clinicaVeterinaria.model.Animal;
import pooa.trabalho.clinicaVeterinaria.repository.AnimalRepository;

@Controller
@RequestMapping(path = "/animais")
public class AnimalController {
    @Autowired
    AnimalRepository animaisTable;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaAnimal");
        mv.addObject("animais",animaisTable.findAll());
        mv.addObject(new Animal());
        return mv;
    }

    @PostMapping
    public String salvar(Animal c) {
        this.animaisTable.save(c);
        return "redirect:/animais";	
    }

    @DeleteMapping(value ="/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        this.animaisTable.deleteById(id);
        return "redirect:/animais";
    }

    @PutMapping(value ="/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("ListaAnimal");
        mv.addObject("animais",animaisTable.findAll());
        mv.addObject("animal",animaisTable.findById(id));
        return mv;
    }
}
