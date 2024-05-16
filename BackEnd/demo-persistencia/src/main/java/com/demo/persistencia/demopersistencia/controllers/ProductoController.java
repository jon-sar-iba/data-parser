package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.ProductoDto;
import com.demo.persistencia.demopersistencia.entidades.Productos;
import com.demo.persistencia.demopersistencia.repositorio.ProductoRepositorio;
import com.demo.persistencia.demopersistencia.services.ProductoServicio;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5501")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ProductoController {

    @Autowired//Inyección de dependencia
    private ProductoServicio servicioProducto;
    @Autowired
    private ProductoRepositorio repositorioProducto;

    @GetMapping("/listarProductos")
    public List<Productos> consultarProductos(){
        return servicioProducto.consultarProducto();
    }
    //Buscar un producto en específico a partir de su idProducto
    @GetMapping("/buscarProducto/{idProducto}")
    public ResponseEntity<Productos> buscarProducto(@PathVariable Integer idProducto){
        Productos producto = repositorioProducto.findById(idProducto).orElse(null);

        if(producto != null){
            return ResponseEntity.ok(producto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/registrarProducto")
    public Productos registrarProducto(@RequestBody ProductoDto productoJson){
        Productos producto = new Productos();
        //Asignar a la entidad los valores que vienen del Json (lo que trae ProductoDto)
        producto.setIntIdProducto(productoJson.getIntIdProducto());
        producto.setCvNombre(productoJson.getCvNombre());
        producto.setDecPrecioUnitario(productoJson.getDecPrecioUnitario());
        producto.setIntAntiguedadXMes(productoJson.getIntAntiguedadXMes());
        
        return servicioProducto.registProductos(producto);
    }
}
