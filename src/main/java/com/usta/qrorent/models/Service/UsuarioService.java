package com.usta.qrorent.models.Service;

import com.usta.qrorent.entities.UsuarioEntity;
import java.util.List;

public interface UsuarioService {

    public List<UsuarioEntity> findAll();

    public void save(UsuarioEntity usuario);

    public UsuarioEntity findById(Integer id);

    public void deleteById(Integer id);

    public UsuarioEntity actualizarUsu(UsuarioEntity usuario);


    public UsuarioEntity findByEmail(String email);
}