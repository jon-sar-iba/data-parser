package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.EstadoDto;
import com.demo.persistencia.demopersistencia.entidades.Estados;
import com.demo.persistencia.demopersistencia.services.EstadoServicio;

@RestController
@RequestMapping("/api")
public class EstadoController {

    @Autowired
    private EstadoServicio servicioEstado;

    @GetMapping("/listarEstados")
    public List<Estados> consultarEstados(){
        return servicioEstado.consultarEstado();
    }

    @PostMapping("/registrarEstados")
    public Estados registrarEstados(@RequestBody EstadoDto estadoJson){
        Estados estado = new Estados();
        //Asignar a la entidad los valores correspondientes
        estado.setCCveEstado(estadoJson.getCCveEstado());
        estado.setCvNombre(estadoJson.getCvNombre());

        return servicioEstado.registEstados(estado);
    }
}
