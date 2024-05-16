package com.demo.persistencia.demopersistencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.persistencia.demopersistencia.entidades.Productos;
import com.demo.persistencia.demopersistencia.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {//Con este servicio se podrá interactura con los datos

    @Autowired//Con esto indicamos que es una inyección de dependencia
    private ProductoRepositorio productoRepositorio;//private nombreDeLaInterfaz nombreVariable;

    public List<Productos> consultarProducto(){
        return (List<Productos>) productoRepositorio.findAll();
    }
    public Optional<Productos> consultarProductoPorId(Integer idProducto){
        return productoRepositorio.findById(idProducto);
    }

    public Productos registProductos(Productos producto){
        return productoRepositorio.save(producto);
    }

}
