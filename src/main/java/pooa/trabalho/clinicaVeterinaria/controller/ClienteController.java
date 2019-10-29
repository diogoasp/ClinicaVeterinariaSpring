package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.trabalho.clinicaVeterinaria.model.Cliente;
import pooa.trabalho.clinicaVeterinaria.repository.ClienteRepository;

@Controller
public class ClienteController {
        @Autowired
	ClienteRepository clientesTable;
	
	@GetMapping("/clientes")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaCliente.html");
		mv.addObject("clientes",clientesTable.findAll());
		mv.addObject(new Cliente());
		return mv;
	}
	
	@PostMapping("/clientes")
	public String salvar(Cliente c) {
		this.clientesTable.save(c);
		return "redirect:/clientes";
		
	}
	
	@RequestMapping(value ="/clientes/excluir/{id}")
	public String excluirClienteByPathVariable(@PathVariable Long id) {
		this.clientesTable.deleteById(id);
		return "redirect:/clientes";
	}
	
	@RequestMapping(value ="/clientes/alterar/{id}")
	public ModelAndView alterarClienteByPathVariable(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaCliente.html");
		mv.addObject("clientes",clientesTable.findAll());
		mv.addObject("cliente",clientesTable.findById(id));
		return mv;
	}
	

}
