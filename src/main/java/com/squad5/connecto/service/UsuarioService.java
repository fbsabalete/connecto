package com.squad5.connecto.service;

import com.squad5.connecto.model.Usuario;
import com.squad5.connecto.model.UsuarioLogin;
import com.squad5.connecto.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrarUsuario(Usuario usuario){
        if(repository.findByEmailIgnoreCase(usuario.getEmail()).isPresent()){
            return null;
        }

        return repository.save(encriptarSenha(usuario));
    }

    public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = repository.findByEmailIgnoreCase(user.get().getEmail());

        if(usuario.isPresent()){
            if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())){
                String auth = user.get().getEmail() + ":" + user.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setNomeCompleto(usuario.get().getNomeCompleto());
                user.get().setFotoPerfil(usuario.get().getFotoPerfil());
                user.get().setTipoAdmin(usuario.get().getTipoAdmin());
                user.get().setTelefone(usuario.get().getTelefone());

                return user;
            }
        }
        return null;
    }

	public Usuario atualizarUsuario(Usuario usuario) {
		
		return repository.save(encriptarSenha(usuario));
	}
	

	public Usuario encriptarSenha(Usuario usuario){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);
        return usuario;

	}
}
