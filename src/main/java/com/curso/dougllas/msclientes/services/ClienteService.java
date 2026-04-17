package com.curso.dougllas.msclientes.services;

import com.curso.dougllas.msclientes.entities.Cliente;
import com.curso.dougllas.msclientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Faiou"));
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
