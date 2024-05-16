package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.FacturaDto;
import com.demo.persistencia.demopersistencia.entidades.Facturas;
import com.demo.persistencia.demopersistencia.services.FacturaServicio;

@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaServicio servicioFactura;

    @GetMapping("/listarFacturas")
    public List<Facturas> consultarFacturas(){
        return servicioFactura.consultarFactura();
    }

    @PostMapping("/registrarFactura")
    public Facturas registrarFactura(@RequestBody FacturaDto facturaJson){
        Facturas factura = new Facturas();

        factura.setIntNumFactura(facturaJson.getIntNumFactura());
        factura.setIntNumCliente(facturaJson.getIntNumCliente());
        factura.setIntCantTiposProductos(facturaJson.getIntCantTiposProductos());
        factura.setDecTotal(facturaJson.getDecTotal());
        factura.setCCveMetodoPago(facturaJson.getCCveMetodoPago());
        factura.setDFecha(facturaJson.getDFecha());
        factura.setCCveEstado(facturaJson.getCCveEstado());
        factura.setCCveEstatus(facturaJson.getCCveEstatus());

        return servicioFactura.registFactura(factura);
    }
}
