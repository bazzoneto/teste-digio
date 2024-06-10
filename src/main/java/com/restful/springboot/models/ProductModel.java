package com.restful.springboot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;
    private String tipo_vinho;
    private BigDecimal preco;

    private Integer safra;

    private Integer ano_compra;

    public Integer getSafra()
    { return safra;}

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getTipo_vinho() {
        return tipo_vinho;
    }

    public void setTipo_vinho(String tipo_vinho) {
        this.tipo_vinho = tipo_vinho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setSafra(Integer safra) {
        this.safra = safra;
    }

    public Integer getano_compra() {
        return ano_compra;
    }

    public void setano_compra(Integer ano_compra) {
        this.ano_compra = ano_compra;
    }
}
