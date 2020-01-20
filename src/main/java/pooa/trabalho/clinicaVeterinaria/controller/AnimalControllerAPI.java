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
import pooa.trabalho.clinicaVeterinaria.model.Animal;
import pooa.trabalho.clinicaVeterinaria.repository.AnimalRepository;

@RestController
@RequestMapping("/api/animais")
public class AnimalControllerAPI {

    @Autowired
    private AnimalRepository repo;
    
    @GetMapping
    public Collection<Animal> getAll() {
        return this.repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Animal> getOne(@PathVariable("id") Long id) {
        return this.repo.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Animal> a = repo.findById(id);
        if (a == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Animal animal) {
        return new ResponseEntity<>(repo.save(animal), HttpStatus.OK);
    }
    
}
