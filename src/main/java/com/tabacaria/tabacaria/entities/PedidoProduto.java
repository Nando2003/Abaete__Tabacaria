package com.tabacaria.tabacaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tabacaria.tabacaria.entities.pk.PedidoProdutoPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido_produto")
public class PedidoProduto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidoProdutoPK id = new PedidoProdutoPK();
    private Double price;
    private Integer quantity;

    public PedidoProduto(){

    }

    public PedidoProduto(Pedido pedido, Produto produto, Double price, Integer quantity) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.price = price;
        this.quantity = quantity;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoProduto that = (PedidoProduto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
