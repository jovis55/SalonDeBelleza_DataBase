package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.ClienteProducto;
import com.example.salondebelleza_database.repository.ClienteProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteProductoService implements ClienteProductoIn {

    private final ClienteProductoRepository clienteProductoRepository;

    @Autowired
    public ClienteProductoService(ClienteProductoRepository clienteProductoRepository) {
        this.clienteProductoRepository = clienteProductoRepository;
    }

    @Override
    public ClienteProducto crearClienteProducto(ClienteProducto clienteProducto) {
        return clienteProductoRepository.save(clienteProducto);
    }

    @Override
    public ClienteProducto actualizarClienteProducto(ClienteProducto clienteProducto) {
        return clienteProductoRepository.save(clienteProducto);
    }

    @Override
    public ClienteProducto obtenerClienteProducto(Long id) {
        Optional<ClienteProducto> clienteProductoOptional = clienteProductoRepository.findById(id);
        return clienteProductoOptional.orElse(null);
    }

    @Override
    public void eliminarClienteProducto(Long id) {
        clienteProductoRepository.deleteById(id);
    }

    @Override
    public List<ClienteProducto> listarClienteProductos() {
        return clienteProductoRepository.findAll();
    }
}
