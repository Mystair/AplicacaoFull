package aplicacao.aulas1.service;

import aplicacao.aulas1.model.Marca;
import aplicacao.aulas1.repository.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca novaMarca(Marca marca){ return marcaRepository.save(marca);
    }

    public List<Marca> listarMarcas(){ return marcaRepository.findAll();}

    public Marca atualizarMarca(Marca marca){
        marcaRepository.findById(marca.getId()).map(Marca ->{
            marca.setNomeMarca(marca.getNomeMarca());
            return marcaRepository.save(marca);
        });
        return marca;
    }

    public void deletarMarca(@PathVariable Long id){
        marcaRepository.deleteById(id);
    }


}
