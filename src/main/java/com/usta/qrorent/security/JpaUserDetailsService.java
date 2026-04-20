//package com.usta.qrorent.security;
//
//import com.usta.qrorent.entities.UsuarioEntity;
//import com.usta.qrorent.models.DAO.UsuarioDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class JpaUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsuarioDAO usuarioDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        System.out.println("Buscando usuario con email: [" + email + "]");
//        UsuarioEntity usuario = usuarioDAO.findByEmail(email);
//        if (usuario == null) {
//            System.out.println("No se encontró usuario con email: " + email);
//            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
//        }
//        System.out.println("Usuario encontrado: " + usuario.getEmail());
//        // ...
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getTipo().name()));
//        return new User(usuario.getEmail(), usuario.getPasswordHash(), authorities);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}