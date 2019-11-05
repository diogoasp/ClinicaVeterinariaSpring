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
import pooa.trabalho.clinicaVeterinaria.model.Cliente;
import pooa.trabalho.clinicaVeterinaria.repository.ClienteRepository;

@Controller
@RequestMapping(path = "/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clientesTable;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaCliente");
        mv.addObject("clientes",clientesTable.findAll());
        mv.addObject(new Cliente());
        return mv;
    }

    @PostMapping
    public String salvar(Cliente c) {
        this.clientesTable.save(c);
        return "redirect:/clientes";	
    }

    @DeleteMapping(value ="/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        this.clientesTable.deleteById(id);
        return "redirect:/clientes";
    }

    @PutMapping(value ="/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("ListaCliente");
        mv.addObject("clientes",clientesTable.findAll());
        mv.addObject("cliente",clientesTable.findById(id));
        return mv;
    }
}