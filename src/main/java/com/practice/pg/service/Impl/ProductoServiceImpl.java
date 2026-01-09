package com.practice.pg.service.Impl;

import com.practice.pg.dao.ProductoDao;
import com.practice.pg.dto.Producto;
import com.practice.pg.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoDao productoDao;

    public ProductoServiceImpl(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @Override
    public Producto crear(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoDao.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(producto.getNombre());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        return productoDao.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        productoDao.deleteById(id);
    }
}