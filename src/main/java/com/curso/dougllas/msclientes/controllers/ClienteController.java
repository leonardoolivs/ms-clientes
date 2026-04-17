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

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
