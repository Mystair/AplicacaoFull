package aplicacao.aulas1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro")
    private Long id;

    @Column(name = "nomecarro")
    private String nomeCarro;

    @Column(name = "anofabricacaocarro")
    private Integer anoFabricacaoCarro;

    @Column(name = "anomodelocarro")
    private Integer anoModeloCarro;

    @Column(name = "modelocarro")
    private String modeloCarro;

    @ManyToOne
    @JoinColumn(name = "marca_idmarca")
    private Marca marca;
}
