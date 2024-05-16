package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.EstatusDto;
import com.demo.persistencia.demopersistencia.entidades.Estatus;
import com.demo.persistencia.demopersistencia.services.EstatusServicio;

@RestController
@RequestMapping("/api")
public class EstatusController {

    @Autowired
    private EstatusServicio servicioEstatus;

    @GetMapping("/listarEstatus")
    public List<Estatus> consultarEstatus(){
        return servicioEstatus.consultarEstatus();
    }

    @PostMapping("/registrarEstatus")
    public Estatus registrarEstatus(@RequestBody EstatusDto estatusJson){
        Estatus status = new Estatus();

        status.setCCveEstatus(estatusJson.getCCveEstatus());
        status.setCvTipo(estatusJson.getCvTipo());

        return servicioEstatus.registEstatus(status);
    }
}
