package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Cliente;

import java.util.List;

public interface ClieneIn {
    List<Cliente> getAllClientes();
    Cliente getClienteById(String id);
    Cliente saveCliente(Cliente cliente);
    void deleteCliente(String id);
}
