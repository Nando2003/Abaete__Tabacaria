package com.tabacaria.tabacaria.resources;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return service.salvarCliente(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> list = service.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        service.deleteCliente(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

}
