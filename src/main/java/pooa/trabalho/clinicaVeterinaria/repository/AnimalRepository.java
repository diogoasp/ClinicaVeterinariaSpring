package pooa.trabalho.clinicaVeterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.trabalho.clinicaVeterinaria.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
