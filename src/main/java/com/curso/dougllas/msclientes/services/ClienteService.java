package com.curso.dougllas.msclientes.services;

import com.curso.dougllas.msclientes.entities.Cliente;
import com.curso.dougllas.msclientes.exceptions.ResourceNotFoundException;
import com.curso.dougllas.msclientes.exceptions.ValidacaoException;
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
        if(repository.existsByCpf(cliente.getCpf())){
            throw new ValidacaoException("CPF já cadastrado");
        }

        return repository.save(cliente);
    }

    @Transactional(readOnly = true)
    public Cliente findByCpf(String cpf){
        Cliente cliente = repository.findByCpf(cpf);
        if(cliente == null){
            throw new ResourceNotFoundException("CPF não encontrado");
        }

        return cliente;
    }
}
