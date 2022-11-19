package com.examen.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PAIS")
public class Pais {

    @Id
    @Column(name = "IDPAIS")
    private String idPais;

    @Column(name = "PAIS")
    private String nombre;

}
