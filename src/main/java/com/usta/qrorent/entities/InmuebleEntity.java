package com.usta.qrorent.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "InmuebleEntity")
public class InmuebleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "arrendador_id", nullable = false)
    private Integer arrendadorId;

    @Column(nullable = false, length = 200)
    private String nombre_inmueble;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoInmueble tipo;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private boolean disponible = true;

    @Column(name = "num_habitacioines")
    private Integer numHabitacioines;

    @Column(name = "num_banos")
    private Integer numBanos;

    private Boolean amueblado;

    private Boolean servicios;

    @Column(name="pet_friendly")
    private Boolean petFriendly;

    @Column(name = "capacidad_personas")
    private Integer capacidadPersonas;

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    @Column(name ="publicado_en")
    private LocalDateTime publicadoEn;

    @Column(name = "calificacion_prom", precision = 3, scale = 2)
    private BigDecimal calificacionProm;

    @PrePersist
    public void prePersist() {
        this.publicadoEn = LocalDateTime.now();
    }

    public enum TipoInmueble {
        CUARTO,
        DEPARTAMENTO,
        CASA_COMPARTIDA,
        ESTUDIO
    }





}
