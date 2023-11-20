package com.tabacaria.tabacaria.resources;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.services.CategoriaService;
import com.tabacaria.tabacaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        try {
            List<Categoria> list = service.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return service.salvarCategoria(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id){
        service.deleteCategoria(id);
    }
}
