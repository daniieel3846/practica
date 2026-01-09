package com.practice.pg.service;

import com.practice.pg.dto.Producto;

import java.util.List;

public interface ProductoService {
    Producto crear(Producto producto);

    List<Producto> listar();

    Producto obtenerPorId(Long id);

    Producto actualizar(Long id, Producto producto);

    void eliminar(Long id);
}
