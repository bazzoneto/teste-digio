package com.restful.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(@NotBlank String nome_cliente, @NotBlank Integer cpf, @NotBlank Integer quantidade) {
}
