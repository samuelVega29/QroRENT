package com.usta.qrorent.models.Service;

import com.usta.qrorent.entities.UsuarioEntity;
import com.usta.qrorent.models.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public List<UsuarioEntity> findAll() {
        return (List<UsuarioEntity>) usuarioDAO.findAll();
    }

    @Override
    @Transactional
    public void save(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    @Transactional
    public UsuarioEntity findById(Integer id) {
        return usuarioDAO.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        usuarioDAO.deleteById(Long.valueOf(id));
    }

    @Override
    @Transactional
    public UsuarioEntity actualizarUsu(UsuarioEntity usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    @Transactional
    public UsuarioEntity findByEmail(String email) {
        return usuarioDAO.findByEmail(email);
    }
}