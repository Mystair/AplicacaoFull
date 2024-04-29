package aplicacao.aulas1.service;

import aplicacao.aulas1.model.Carro;
import aplicacao.aulas1.repository.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro novoCarro(Carro carro){
        //marca
        //cor
        return carroRepository.save(carro);
    }

    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }

    public Carro atualizarCarro(Carro carro){
        carroRepository.findById(carro.getId()).map(Carro ->{
            carro.setNomeCarro(carro.getNomeCarro());
            carro.setAnoFabricacaoCarro(carro.getAnoModeloCarro());
            carro.setAnoModeloCarro(carro.getAnoModeloCarro());
            carro.setModeloCarro(carro.getModeloCarro());
            carro.setMarca(carro.getMarca());
            return carroRepository.save(carro);
        });
        return carro;
    }

    public void deletarCarro(@PathVariable Long id){carroRepository.deleteById(id);
    }
}
