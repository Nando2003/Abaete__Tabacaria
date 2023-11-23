package com.tabacaria.tabacaria.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tabacaria.tabacaria.entities.enums.TipoPagamento;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    private Integer tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoProduto> items = new HashSet<>();

    public Pedido(){
    }

    public Long getId() {
        return id;
    }

    public Pedido(Long id, String date_s, TipoPagamento tipoPagamento, Cliente cliente) throws ParseException {
        this.id = id;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.parse(date_s);

        setTipoPagamento(tipoPagamento);
        this.cliente = cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.valueOf(tipoPagamento);
    }

    public Set<PedidoProduto> getItems() {
        return items;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (PedidoProduto x : items){
            sum += x.getSubTotal();
        }
        return sum;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        if (tipoPagamento != null) {
            this.tipoPagamento = tipoPagamento.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {

        return "Pedido{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", TipoPagamento='" + tipoPagamento + '\'' +
                ", Cliente ='" + cliente + '\'' +
                '}';
    }

}
