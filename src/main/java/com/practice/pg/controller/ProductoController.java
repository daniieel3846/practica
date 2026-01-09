package com.practice.pg.controller;

import com.practice.pg.dto.Producto;
import com.practice.pg.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public Producto crear(@RequestBody Producto producto) {
        System.out.println("test");
        return service.crear(producto);
    }

    @GetMapping("/listar")
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("listar/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("actualizar/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Producto producto) {
        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}