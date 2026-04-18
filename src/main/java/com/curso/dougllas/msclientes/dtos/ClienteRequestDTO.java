package com.curso.dougllas.msclientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private Integer idade;

}


