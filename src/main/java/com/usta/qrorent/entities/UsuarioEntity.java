package com.usta.qrorent.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "telefono")
    private String telefono;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

    @PrePersist
    public void prePersist() {
        this.creadoEn = LocalDateTime.now();
    }
}