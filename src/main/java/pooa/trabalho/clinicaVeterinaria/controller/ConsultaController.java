package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.trabalho.clinicaVeterinaria.model.Consulta;
import pooa.trabalho.clinicaVeterinaria.repository.ConsultaRepository;

@Controller
public class ConsultaController {
        @Autowired
	ConsultaRepository consultasTable;
	
	@GetMapping("/consultas")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConsulta.html");
		mv.addObject("consultas",consultasTable.findAll());
		mv.addObject(new Consulta());
		return mv;
	}
	
	@PostMapping("/consultas")
	public String salvar(Consulta c) {
		this.consultasTable.save(c);
		return "redirect:/consultas";
		
	}
	
	@RequestMapping(value ="/consultas/excluir/{id}")
	public String excluirConsultaByPathVariable(@PathVariable Long id) {
		this.consultasTable.deleteById(id);
		return "redirect:/consultas";
	}
	
	@RequestMapping(value ="/consultas/alterar/{id}")
	public ModelAndView alterarConsultaByPathVariable(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaConsulta.html");
		mv.addObject("consultas",consultasTable.findAll());
		mv.addObject("consulta",consultasTable.findById(id));
		return mv;
	}
	

}
