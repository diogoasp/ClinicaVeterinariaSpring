package pooa.trabalho.clinicaVeterinaria.controller;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pooa.trabalho.clinicaVeterinaria.model.Consulta;
import pooa.trabalho.clinicaVeterinaria.repository.ConsultaRepository;


@RestController
@RequestMapping("/api/consultas")
public class ConsultaControllerAPI {

    @Autowired
    private ConsultaRepository repo;
    
    @GetMapping
    public Collection<Consulta> getAll() {
        return this.repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Consulta> getOne(@PathVariable("id") Long id) {
        return this.repo.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Consulta> c = repo.findById(id);
        if (c == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Consulta animal) {
        return new ResponseEntity<>(repo.save(animal), HttpStatus.OK);
    }
    
}
