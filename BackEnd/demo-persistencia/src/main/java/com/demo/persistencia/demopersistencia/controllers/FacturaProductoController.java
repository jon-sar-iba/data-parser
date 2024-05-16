package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.FacturaProductoDto;
import com.demo.persistencia.demopersistencia.entidades.FacturasProductos;
import com.demo.persistencia.demopersistencia.services.FacturaProductoServicio;

@RestController
@RequestMapping("/api")
public class FacturaProductoController {

    @Autowired
    private FacturaProductoServicio servicioFacPro;

    @GetMapping("/listarFacturasProductos")
    public List<FacturasProductos> consultarFacturasProductos(){
        return servicioFacPro.consultarFacturaProducto();
    }

    @PostMapping("/registrarFacturaProducto")
    private FacturasProductos registrarFacturaProducto(@RequestBody FacturaProductoDto facturaProductoJson){
        FacturasProductos facturaProducto = new FacturasProductos();

        facturaProducto.setIntNumFactura(facturaProductoJson.getIntNumFactura());
        facturaProducto.setIntIdProducto(facturaProductoJson.getIntIdProducto());
        facturaProducto.setIntCantidad(facturaProductoJson.getIntCantidad());

        return servicioFacPro.registFacturaProducto(facturaProducto);
    }
}
