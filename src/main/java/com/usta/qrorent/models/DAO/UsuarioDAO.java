package com.usta.qrorent.models.DAO;

import com.usta.qrorent.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioDAO extends CrudRepository<UsuarioEntity, Long> {

    @Transactional
    @Query("SELECT u FROM UsuarioEntity u WHERE u.email = ?1")
    public UsuarioEntity findByEmail(String email);


}