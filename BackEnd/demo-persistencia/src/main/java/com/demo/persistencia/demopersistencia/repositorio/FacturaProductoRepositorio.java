package com.demo.persistencia.demopersistencia.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.demo.persistencia.demopersistencia.entidades.FacturasProductos;

public interface FacturaProductoRepositorio extends CrudRepository<FacturasProductos, Integer>{

}
