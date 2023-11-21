package com.tabacaria.tabacaria.resources;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.entities.Endereco;
import com.tabacaria.tabacaria.services.CategoriaService;
import com.tabacaria.tabacaria.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        try {
            List<Endereco> list = service.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return service.salvarEndereco(endereco);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable Long id){
        service.deleteEndereco(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}
