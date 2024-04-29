package aplicacao.aulas1.controller;

import aplicacao.aulas1.model.Marca;
import aplicacao.aulas1.service.MarcaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "/marca")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @Transactional
    @PostMapping("/marcas/novamarca")
    public ResponseEntity<Marca> novaMarca(@RequestBody Marca marcaRequest){
        Marca marca = marcaService.novaMarca(marcaRequest);
        return new ResponseEntity<>(marca, HttpStatus.CREATED);
    }

    @GetMapping("/marcas")
    public ResponseEntity<List<Marca>> listarMarcas(){
        List<Marca> lista = marcaService.listarMarcas();
        return ResponseEntity.ok().body(lista);
    }

    @Transactional
    @PutMapping("/marcas/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @RequestBody Marca marcaRequest){
        Marca marca = marcaService.atualizarMarca(marcaRequest);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/marcas/{id}")
    public void deletarMarca (@PathVariable Long id){
        marcaService.deletarMarca(id);
        ResponseEntity.noContent().build();
    }


}
