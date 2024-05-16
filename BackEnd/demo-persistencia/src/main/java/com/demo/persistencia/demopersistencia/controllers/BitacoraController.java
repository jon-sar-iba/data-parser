package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.BitacoraDto;
import com.demo.persistencia.demopersistencia.entidades.Bitacoras;
import com.demo.persistencia.demopersistencia.services.BitacoraServicio;

@RestController
@RequestMapping("/api")
public class BitacoraController {

    @Autowired
    private BitacoraServicio servicioBitacora;

    @GetMapping("/listarBitacoras")
    public List<Bitacoras> consultarBitacora(){
        return servicioBitacora.consultarBicatora();
    }

    @PostMapping("/registrarBitacora")
    public Bitacoras registrarBitacora(@RequestBody BitacoraDto bitacoraJson){
        Bitacoras bitacora = new Bitacoras();

        bitacora.setIntNumFactura(bitacoraJson.getIntNumFactura());
        bitacora.setBRegistroExitoso(bitacoraJson.getBRegistroExitoso());
        bitacora.setCvDescripcion(bitacoraJson.getCvDescripcion());
        bitacora.setDFecha(bitacoraJson.getDFecha());

        return servicioBitacora.registBitacora(bitacora);
    }
}
