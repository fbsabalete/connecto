package com.squad5.connecto.security;

import com.squad5.connecto.model.Usuario;
import com.squad5.connecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName){
        Optional<Usuario> user = repository.findByEmailIgnoreCase(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}
