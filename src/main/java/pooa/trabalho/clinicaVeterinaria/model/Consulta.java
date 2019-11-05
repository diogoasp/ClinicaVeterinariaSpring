package pooa.trabalho.clinicaVeterinaria.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.DATE)
    @Column(length = 10, nullable = false)
    private Calendar dtConsulta;
    
    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal bicho;

    public Animal getBicho() {
        return bicho;
    }

    public void setBicho(Animal bicho) {
        this.bicho = bicho;
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

    public Calendar getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Calendar dtConsulta) {
        this.dtConsulta = dtConsulta;
    }
    
    public String getNomeCliente(){
        return bicho.getNomeProprietario();
    }
}
