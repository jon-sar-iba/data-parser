package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.MetodoPagoDto;
import com.demo.persistencia.demopersistencia.entidades.MetodosPagos;
import com.demo.persistencia.demopersistencia.services.MetodoPagoServicio;

@RestController
@RequestMapping("/api")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoServicio servicioMetPago;

    @GetMapping("/listarMetodosPago")
    public List<MetodosPagos> consultarMetodosPagos(){
        return servicioMetPago.consultarMetodoPago();
    }

    @PostMapping("/registrarMetodoPago")
    public MetodosPagos registrarMetodoPago(@RequestBody MetodoPagoDto metodoPagoJson){
        MetodosPagos metodoPago = new MetodosPagos();
        
        metodoPago.setCCveMetodoPago(metodoPagoJson.getCCveMetodoPago());
        metodoPago.setCvTipo(metodoPagoJson.getCvTipo());

        return servicioMetPago.registMetodosPagos(metodoPago);
    }
}
