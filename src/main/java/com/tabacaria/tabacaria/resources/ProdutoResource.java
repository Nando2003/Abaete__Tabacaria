package com.tabacaria.tabacaria.resources;

import com.tabacaria.tabacaria.entities.Produto;
import com.tabacaria.tabacaria.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        try {
            List<Produto> list = service.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public Produto salvarCategoria(@RequestBody Produto categoria) {
        return service.salvarCategoria(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id){
        service.deleteProduto(id);
    }
}
