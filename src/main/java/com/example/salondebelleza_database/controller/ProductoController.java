package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Producto;
import com.example.salondebelleza_database.service.ProductoService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.crearProducto(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("idProducto") int idProducto, @RequestBody Producto productoActualizado) {
        try {
            // Obtener el producto existente de la base de datos utilizando su ID
            Producto productoExistente = productoService.obtenerProducto(idProducto);

            // Verificar si se encontró el producto
            if (productoExistente != null) {
                // Actualizar las propiedades relevantes del producto con los datos proporcionados en la solicitud
                productoExistente.setNombre(productoActualizado.getNombre());
                productoExistente.setDescripcion(productoActualizado.getDescripcion());
                productoExistente.setImagen_url(productoActualizado.getImagen_url());
                productoExistente.setPrecio(productoActualizado.getPrecio());
                productoExistente.setStock_dispo(productoActualizado.getStock_dispo());

                // Guardar el producto actualizado en la base de datos
                Producto productoGuardado = productoService.actualizarProducto(productoExistente);

                // Devolver una respuesta con el producto actualizado
                return ResponseEntity.ok(productoGuardado);
            } else {
                // Si no se encuentra el producto, devolver una respuesta de error
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar cualquier excepción y devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("idProducto") int idProducto) {
        try {
            Producto producto = productoService.obtenerProducto(idProducto);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("idProducto") int idProducto) {
        try {
            productoService.eliminarProducto(idProducto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        try {
            List<Producto> productos = productoService.listarProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
