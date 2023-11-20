package com.tabacaria.tabacaria.services;

import com.tabacaria.tabacaria.entities.Produto;
import com.tabacaria.tabacaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return  repository.findAll();
    }

    public Produto salvarCategoria(Produto categoria) {
        return repository.save(categoria);
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

    public void deleteProduto(Long id){
        repository.deleteById(id);
    }

}


