package com.demo.persistencia.demopersistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturaproducto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturasProductos {

    @Id
    @Column(name = "int_num_factura")
    private Integer intNumFactura;
    @Column(name = "int_id_producto")
    private Integer intIdProducto;
    @Column(name = "int_cantidad")
    private Integer intCantidad;
}
