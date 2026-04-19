package com.usta.qrorent.controllers;

import com.usta.qrorent.entities.TipoUsuario;
import com.usta.qrorent.entities.UsuarioEntity;
import com.usta.qrorent.models.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccesoController {

    @Autowired
    private UsuarioService usuarioService;

    //Mostrar formulario
    @GetMapping("/login")
    public String mostrarLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        if (error != null) model.addAttribute("error", true);
        if (logout != null) model.addAttribute("logout", true);
        return "login";
    }

    // login
    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        UsuarioEntity usuario = usuarioService.findByEmail(email);

        if (usuario == null || !usuario.getPasswordHash().equals(password)) {
            return "redirect:/login?error";
        }

        session.setAttribute("usuario", usuario);
        return "redirect:/";
    }

    // GET /registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "register";
    }

    // POST /register
    @PostMapping("/register")
    public String registrarUsuario(
            @ModelAttribute UsuarioEntity usuario,
            @RequestParam("confirmarClave") String confirmarClave,
            Model model) {

        if (!usuario.getPasswordHash().equals(confirmarClave)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            model.addAttribute("usuario", usuario);
            return "register";
        }

        if (usuarioService.findByEmail(usuario.getEmail()) != null) {
            model.addAttribute("error", "Ya existe una cuenta con ese correo");
            model.addAttribute("usuario", usuario);
            return "register";
        }

        if (usuario.getTipo() == null) {
            usuario.setTipo(TipoUsuario.ESTUDIANTE);
        }

        usuarioService.save(usuario);
        return "redirect:/login?registered";
    }

    // Cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}