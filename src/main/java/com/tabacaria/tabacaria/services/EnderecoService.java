package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.entities.Endereco;
import com.tabacaria.tabacaria.repositories.CategoriaRepository;
import com.tabacaria.tabacaria.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll(){
        return  repository.findAll();
    }

    public Endereco salvarEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco findById(Long id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.get();
    }

    public void deleteEndereco(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Endereco update(Long id, Endereco obj){
        Endereco entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Endereco entity, Endereco obj){

        Endereco existingEndereco = repository.findById(entity.getId()).orElseThrow(() -> new EntityNotFoundException("Endereco not found"));

        entity.setRoad(obj.getRoad());
        entity.setNumber(obj.getNumber());
        entity.setComplement(obj.getComplement());
        entity.setCliente(obj.getCliente());
    }

}


