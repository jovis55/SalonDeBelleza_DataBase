package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Producto;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import com.example.salondebelleza_database.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService implements ProductoIn {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) throws AttributeException {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws AttributeException {
        Optional<Producto> productoOptional = productoRepository.findById(producto.getId_producto());
        if (productoOptional.isPresent()) {
            return productoRepository.save(producto);
        } else {
            throw new AttributeException("Producto no encontrado en la base de datos.");
        }
    }

    @Override
    public Producto obtenerProducto(int idProducto) throws AttributeException {
        Optional<Producto> productoOptional = productoRepository.findById(idProducto);
        if (productoOptional.isPresent()) {
            return productoOptional.get();
        } else {
            throw new AttributeException("Producto no encontrado en la base de datos.");
        }
    }

    @Override
    public void eliminarProducto(int idProducto) throws AttributeException {
        if (existeProducto(idProducto)) {
            productoRepository.deleteById(idProducto);
        } else {
            throw new AttributeException("Producto no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existeProducto(int idProducto) {
        return productoRepository.existsById(idProducto);
    }

    @Override
    public List<Producto> listarProductos() throws AttributeException {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar los productos.");
        }
    }
}
