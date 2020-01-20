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
import pooa.trabalho.clinicaVeterinaria.model.Cliente;
import pooa.trabalho.clinicaVeterinaria.repository.ClienteRepository;


@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerAPI {

    @Autowired
    private ClienteRepository repo;
    
    @GetMapping
    public Collection<Cliente> getAll() {
        return this.repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Cliente> getOne(@PathVariable("id") Long id) {
        return this.repo.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Cliente> c = repo.findById(id);
        if (c == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Cliente animal) {
        return new ResponseEntity<>(repo.save(animal), HttpStatus.OK);
    }
    
}
