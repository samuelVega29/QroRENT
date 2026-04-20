//package com.usta.qrorent.handler;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ARRENDADOR"))) {
//            setDefaultTargetUrl("/inmueble/nuevo");
//        } else {
//            setDefaultTargetUrl("/dashboard");
//        }
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}