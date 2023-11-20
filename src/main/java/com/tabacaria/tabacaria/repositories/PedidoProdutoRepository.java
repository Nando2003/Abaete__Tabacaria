package com.tabacaria.tabacaria.repositories;

import com.tabacaria.tabacaria.entities.Categoria;
import com.tabacaria.tabacaria.entities.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

}
