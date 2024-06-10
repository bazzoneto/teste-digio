package com.restful.springboot.dtos;

public class PurchaseYearDto {
    private Integer anoCompra;

    public PurchaseYearDto(Integer anoCompra) {
        this.anoCompra = anoCompra;
    }

    public Integer getAnoCompra() {
        return anoCompra;
    }

    public void setAnoCompra(Integer anoCompra) {
        this.anoCompra = anoCompra;
    }
}
