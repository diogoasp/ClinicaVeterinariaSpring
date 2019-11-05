package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.trabalho.clinicaVeterinaria.model.Consulta;
import pooa.trabalho.clinicaVeterinaria.repository.AnimalRepository;
import pooa.trabalho.clinicaVeterinaria.repository.ConsultaRepository;

@Controller
@RequestMapping(path = "/consultas")
public class ConsultaController {
    @Autowired
    ConsultaRepository consultasTable;
    @Autowired
    AnimalRepository animaisTable;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaConsulta");
        mv.addObject("consultas",consultasTable.findAll());
        mv.addObject("animais", animaisTable.findAll());
        mv.addObject(new Consulta());
        return mv;
    }

    @PostMapping
    public String salvar(Consulta c) {
        this.consultasTable.save(c);
        return "redirect:/consultas";	
    }

    @GetMapping(value ="/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        this.consultasTable.deleteById(id);
        return "redirect:/consultas";
    }

    @GetMapping(value ="/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("ListaConsulta");
        mv.addObject("consultas",consultasTable.findAll());
        mv.addObject("animais", animaisTable.findAll());
        mv.addObject("consulta",consultasTable.findById(id));
        return mv;
    }
}