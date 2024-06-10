package com.restful.springboot.models;

import java.math.BigDecimal;

public class PurchaseModel {
    private Long id; // ou qualquer outro tipo de identificador que você esteja usando
    private ClientRecordModel nome_cliente;
    private ProductModel nome;
    private int quantidade;
    private BigDecimal totalValue;
}



