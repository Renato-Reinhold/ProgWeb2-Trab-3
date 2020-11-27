package com.progweb.programacaoweb.service;

import com.progweb.programacaoweb.dao.VendedorDAO;
import com.progweb.programacaoweb.model.Vendedor;
import com.progweb.programacaoweb.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private VendedorDAO vendedorDAO;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Vendedor vendedor = null;
        for (Vendedor i : vendedorDAO.findAll()){
            if (i.getNome().equals(usuario)){
                vendedor = i;
            }
        }

        if (vendedor == null){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }

        return new UserSS(vendedor.getId(), vendedor.getNome(), vendedor.getSenha(), vendedor.getPerfis());
    }
}
