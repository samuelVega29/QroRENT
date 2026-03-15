package com.usta.qrorent.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UbicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false)
    private String colonia;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private Double latitud;


    @Column(nullable = false)
    private Double longitud;


}
