package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.repositories.CategoriaRepository;
import com.tabacaria.tabacaria.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return  repository.findAll();
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.get();
    }

    public void deleteCategoria(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Categoria update(Long id, Categoria obj){
        Categoria entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Categoria entity, Categoria obj){

        Categoria existingCategoria = repository.findById(entity.getId()).orElseThrow(() -> new EntityNotFoundException("Cliente not found"));

        entity.setName(obj.getName());
    }

}


