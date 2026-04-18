package com.curso.dougllas.msclientes.dtos.mapper;

import com.curso.dougllas.msclientes.dtos.ClienteRequestDTO;
import com.curso.dougllas.msclientes.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

    ClienteRequestDTO toDTO(Cliente entity);

    List<ClienteRequestDTO> toDTOList(List<Cliente> entities);

    List<Cliente> toEntityList(List<ClienteRequestDTO> dtos);
}
