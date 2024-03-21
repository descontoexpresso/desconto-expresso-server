package com.generation.descontoexpresso.security;

import java.util.Optional;

import com.generation.descontoexpresso.model.Usuario;
import com.generation.descontoexpresso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Usuario> email = usuarioRepository.findByEmailUsuario(userName);

        if (email.isPresent())
            return new UserDetailsImpl(email.get());
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }
}