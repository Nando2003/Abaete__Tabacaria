package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Cliente;
import com.tabacaria.tabacaria.entities.Produto;
import com.tabacaria.tabacaria.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return  repository.findAll();
    }

    public Produto salvarProduto(Produto categoria) {
        return repository.save(categoria);
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

    public void deleteProduto(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Produto update(Long id, Produto obj){
        Produto entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Produto entity, Produto obj){

        Produto existingProduto = repository.findById(entity.getId()).orElseThrow(() -> new EntityNotFoundException("Produto not found"));

        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
        entity.setStock(obj.getStock());
        entity.setCategoria(obj.getCategoria());
    }
}



