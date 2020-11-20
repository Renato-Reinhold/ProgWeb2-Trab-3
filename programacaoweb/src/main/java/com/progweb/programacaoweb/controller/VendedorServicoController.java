package com.progweb.programacaoweb.controller;


import com.progweb.programacaoweb.dao.VendedorDAO;
import com.progweb.programacaoweb.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorServicoController {

    @Autowired
    private VendedorDAO vendedorDAO;

    @GetMapping
    public List<Vendedor> Get() {
        return vendedorDAO.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vendedor> GetById(@PathVariable("id") Long id) {
        Optional<Vendedor> vendedor = vendedorDAO.findById(id);
        if(vendedor.isPresent()){
            return new ResponseEntity<>(vendedor.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> Post(@RequestBody Vendedor vendedor) {
        Vendedor newVendedor = vendedorDAO.save(vendedor);
        if(newVendedor != null){
            return new ResponseEntity<>("Vendedor criado com sucesso!!", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vendedor> Put(@PathVariable("id") Long id, @RequestBody Vendedor newVendedor) {
        Optional<Vendedor> oldVendedor = vendedorDAO.findById(id);
        if(oldVendedor.isPresent()){
            Vendedor vendedor = oldVendedor.get();
            vendedor.setNome(newVendedor.getNome());
            vendedor.setSenha(newVendedor.getSenha());
            vendedor.setEmail(newVendedor.getEmail());
            vendedorDAO.save(vendedor);
            return new ResponseEntity<>(vendedor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
        Optional<Vendedor> vendedor = vendedorDAO.findById(id);
        if(vendedor.isPresent()){
            vendedorDAO.delete(vendedor.get());
            return new ResponseEntity<>("Vendedor deletado com sucesso!!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
