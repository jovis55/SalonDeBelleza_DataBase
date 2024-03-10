package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Cliente;
import com.example.salondebelleza_database.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClieneIn {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(String id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(String id) {
        clienteRepository.deleteById(id);
    }
}