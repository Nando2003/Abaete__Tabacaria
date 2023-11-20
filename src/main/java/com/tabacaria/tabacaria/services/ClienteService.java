package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll(){
        return  repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.get();
    }

    public void deleteCliente(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Cliente update(Long id, Cliente obj){
        Cliente entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Cliente entity, Cliente obj){

        Cliente existingCliente = repository.findById(entity.getId()).orElseThrow(() -> new EntityNotFoundException("Cliente not found"));

        entity.setName(obj.getName());
        entity.setLastname(obj.getLastname());
        entity.setCpf(obj.getCpf());
        entity.setEmail(obj.getEmail());
        entity.setDate_birth(obj.getDate_birth());
    }
}


