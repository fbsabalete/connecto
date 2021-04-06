package com.squad5.connecto.controller;

import com.squad5.connecto.model.Usuario;
import com.squad5.connecto.model.UsuarioLogin;
import com.squad5.connecto.repository.UsuarioRepository;
import com.squad5.connecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> authencation(@RequestBody Optional<UsuarioLogin> user){
        return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        Optional<Usuario> user = Optional.ofNullable(usuarioService.cadastrarUsuario(usuario));

        try {
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById (@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
    	Optional<Usuario> user = Optional.ofNullable(usuarioService.atualizarUsuario(usuario));

        try {
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
