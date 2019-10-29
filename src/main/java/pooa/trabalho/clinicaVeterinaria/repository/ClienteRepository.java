package pooa.trabalho.clinicaVeterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.trabalho.clinicaVeterinaria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
