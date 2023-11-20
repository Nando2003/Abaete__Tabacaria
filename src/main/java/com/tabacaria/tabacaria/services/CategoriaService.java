package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.repositories.CategoriaRepository;
import com.tabacaria.tabacaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}


