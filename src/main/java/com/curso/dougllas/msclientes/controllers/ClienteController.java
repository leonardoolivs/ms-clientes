package com.curso.dougllas.msclientes.controllers;

import com.curso.dougllas.msclientes.entities.Cliente;
import com.curso.dougllas.msclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
        return service.save(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente findByCpf(@PathVariable("cpf") String cpf){
        return service.findByCpf(cpf);
    }

}
