package aplicacao.aulas1.service;

import aplicacao.aulas1.model.Cor;
import aplicacao.aulas1.repository.CorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class CorService {

    private final CorRepository corRepository;

    public CorService(CorRepository corRepository) {
        this.corRepository = corRepository;
    }

    public Cor novaCor(Cor cor){ return corRepository.save(cor);
    }

    public List<Cor> listarCores(){
        return corRepository.findAll();
    }

    public Cor atualizarCor(Cor cor){
        corRepository.findById(cor.getId()).map(Cor ->{
            cor.setNomeCor(cor.getNomeCor());
            return corRepository.save(cor);
        });
       return cor;
    }

    public void deletarCor(@PathVariable Long id){corRepository.deleteById(id);
    }
}
