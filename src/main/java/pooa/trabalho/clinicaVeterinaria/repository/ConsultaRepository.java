package pooa.trabalho.clinicaVeterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.trabalho.clinicaVeterinaria.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
