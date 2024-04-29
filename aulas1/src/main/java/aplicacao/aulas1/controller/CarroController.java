package aplicacao.aulas1.controller;

import aplicacao.aulas1.model.Carro;
import aplicacao.aulas1.service.CarroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "/carros")
public class CarroController {

    private final CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @Transactional
    @PostMapping("/carros/novocarro")
    public ResponseEntity<Carro> novoCarro(@RequestBody Carro carroRequest){
        Carro carro = carroService.novoCarro(carroRequest);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> lista = carroService.listarCarros();
        return ResponseEntity.ok().body(lista);
    }

    @Transactional
    @PutMapping("carros/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carroRequest){
        Carro carro = carroService.atualizarCarro(carroRequest);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("carros/{id}")
    public void deletarCarro(@PathVariable Long id){
        carroService.deletarCarro(id);
        ResponseEntity.noContent().build();
    }

}
