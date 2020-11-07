package com.br.progweb2.controller;

import com.br.progweb2.entity.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VendedorServicoController {

    private static Map<String, Vendedor> vendedores = new HashMap<>();

    @RequestMapping(value = "/vendedores")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }

    @RequestMapping(value = "/vendedores/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(@PathVariable("id") String id) {
        return new ResponseEntity<>(vendedores.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/vendedores", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Vendedor vendedor) {
        vendedores.put(vendedor.getId(), vendedor);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vendedores/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Vendedor vendedor) {
        vendedores.remove(id);
        vendedor.setId(id);
        vendedores.put(id, vendedor);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/vendedores/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        vendedores.remove(id);
        return new ResponseEntity<>("Vendedor deletado com sucesso", HttpStatus.OK);
    }

    public String showVendedors(){
        return vendedores.toString();
    }

}
