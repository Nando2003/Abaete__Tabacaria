package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.entities.Pedido;
import com.tabacaria.tabacaria.repositories.ClienteRepository;
import com.tabacaria.tabacaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido salvarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public List<Pedido> findAll(){
        return  repository.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }

    public void deletePedido(Long id){
        repository.deleteById(id);
    }

}


