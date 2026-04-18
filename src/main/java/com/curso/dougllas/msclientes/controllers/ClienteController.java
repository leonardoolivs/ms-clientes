package com.curso.dougllas.msclientes.controllers;

import com.curso.dougllas.msclientes.dtos.ClienteRequestDTO;
import com.curso.dougllas.msclientes.dtos.mapper.ClienteMapper;
import com.curso.dougllas.msclientes.entities.Cliente;
import com.curso.dougllas.msclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequestDTO dto){

        Cliente cliente = service.save(mapper.toEntity(dto));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(cliente.getCpf()).toUri();

        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> findByCpf(@PathVariable("cpf") String cpf){

        Cliente cliente = service.findByCpf(cpf);

        return ResponseEntity.ok(cliente);
    }

}
