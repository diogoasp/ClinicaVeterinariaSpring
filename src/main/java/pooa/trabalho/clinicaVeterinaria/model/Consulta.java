package pooa.trabalho.clinicaVeterinaria.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Consulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false)
    private String nomeVeterinario;
    @Column(length = 250, nullable = false)
    private String sintomas;
    @Column(length = 300, nullable = true)
    private String diagnostico;
    @Column(length = 10, nullable = false)
    private String dtConsulta;
    
    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(String dtConsulta) {
        this.dtConsulta = dtConsulta;
    }
    
    public String getNomeCliente(){
        return animal.getNomeProprietario();
    }
    
    public String getNomeAnimal(){
        return animal.getNome();
    }
}
