package com.generation.descontoexpresso.service;

import java.util.Optional;

import com.generation.descontoexpresso.model.Usuario;
import com.generation.descontoexpresso.model.UsuarioLogin;
import com.generation.descontoexpresso.repository.UsuarioRepository;
import com.generation.descontoexpresso.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario()).isPresent())
            return Optional.empty();

        usuario.setSenhaUsuario(criptografarSenha(usuario.getSenhaUsuario()));

        return Optional.of(usuarioRepository.save(usuario));

    }

    public Optional<Usuario> atualizarUsuario(Usuario usuario) {

        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

            usuario.setSenhaUsuario(criptografarSenha(usuario.getSenhaUsuario()));

            return Optional.ofNullable(usuarioRepository.save(usuario));

        }

        return Optional.empty();

    }

    public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {

        // Gera o Objeto de autenticação
        var credenciais = new UsernamePasswordAuthenticationToken(usuarioLogin.get().getEmailUsuario(), usuarioLogin.get().getSenhaUsuario());

        // Autentica o Usuario
        Authentication authentication = authenticationManager.authenticate(credenciais);

        // Se a autenticação foi efetuada com sucesso
        if (authentication.isAuthenticated()) {

            // Busca os dados do usuário
            Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario(usuarioLogin.get().getEmailUsuario());

            // Se o usuário foi encontrado
            if (usuario.isPresent()) {

                // Preenche o Objeto usuarioLogin com os dados encontrados
                usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setNomeUsuario(usuario.get().getNomeUsuario());
                usuarioLogin.get().setFotoUsuario(usuario.get().getFotoUsuario());
                usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getEmailUsuario()));
                usuarioLogin.get().setSenhaUsuario("");

                // Retorna o Objeto preenchido
                return usuarioLogin;

            }

        }

        return Optional.empty();

    }

    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(senha);

    }

    private String gerarToken(String usuario) {
        return "Bearer " + jwtService.generateToken(usuario);
    }

}