package aplicacao.aulas1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cor")
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcor")
    private Long id;

    @Column(name = "nomecor")
    private String nomeCor;
}
