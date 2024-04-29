package aplicacao.aulas1.controller;

import aplicacao.aulas1.model.Cor;
import aplicacao.aulas1.service.CorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "/cor")
public class CorController {

    private final CorService corService;

    @Autowired
    public CorController(CorService corService) { this.corService = corService;
    }

    @Transactional
    @PostMapping("/cores/novacor")
    public ResponseEntity<Cor> novaCor(@RequestBody Cor corRequest){
        Cor cor = corService.novaCor(corRequest);
        return new ResponseEntity<>(cor, HttpStatus.CREATED);
    }

    @GetMapping("/cores")
    public ResponseEntity<List<Cor>> listarCores(){
        List<Cor> lista = corService.listarCores();
        return ResponseEntity.ok().body(lista);
    }

    @Transactional
    @PutMapping("/cores/{id}")
    public ResponseEntity<Cor> atualizarCor(@PathVariable Long id, @RequestBody Cor corRequest){
        Cor cor = corService.atualizarCor(corRequest);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/cores/{id}")
    public void deletarCor(@PathVariable Long id){
        corService.deletarCor(id);
        ResponseEntity.noContent().build();
    }
}
