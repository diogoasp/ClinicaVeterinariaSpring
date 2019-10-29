package pooa.trabalho.clinicaVeterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.trabalho.clinicaVeterinaria.model.Animal;
import pooa.trabalho.clinicaVeterinaria.repository.AnimalRepository;

@Controller
public class AnimalController {
        @Autowired
	AnimalRepository animaisTable;
	
	@GetMapping("/animais")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAnimal.html");
		mv.addObject("animais",animaisTable.findAll());
		mv.addObject(new Animal());
		return mv;
	}
	
	@PostMapping("/animais")
	public String salvar(Animal c) {
		this.animaisTable.save(c);
		return "redirect:/animais";
		
	}
	
	@RequestMapping(value ="/animais/excluir/{id}")
	public String excluirAnimalByPathVariable(@PathVariable Long id) {
		this.animaisTable.deleteById(id);
		return "redirect:/animais";
	}
	
	@RequestMapping(value ="/animais/alterar/{id}")
	public ModelAndView alterarAnimalByPathVariable(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaAnimal.html");
		mv.addObject("animais",animaisTable.findAll());
		mv.addObject("animal",animaisTable.findById(id));
		return mv;
	}
	

}
