package com.tabacaria.tabacaria.resources;

import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.entities.Pedido;
import com.tabacaria.tabacaria.services.ClienteService;
import com.tabacaria.tabacaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @PostMapping
    public Pedido salvarPedido(@RequestBody Pedido pedido) {
        return service.salvarPedido(pedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        try {
            List<Pedido> list = service.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id){
        service.deletePedido(id);
    }

}
