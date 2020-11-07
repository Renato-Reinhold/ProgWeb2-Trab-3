package com.br.progweb2.controller;

import com.br.progweb2.dao.ProdutoDAO;
import com.br.progweb2.entity.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProdutoServicoController {

    private static Map<String, Produto> produtos = new HashMap<>();

    @RequestMapping(value = "/produtos")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(@PathVariable("id") String id) {
        return new ResponseEntity<>(produtos.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Produto produto) {
        produtos.put(produto.getId(), produto);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Produto produto) {
        produtos.remove(id);
        produto.setId(id);
        produtos.put(id, produto);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        produtos.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    public String showProdutos(){
        return produtos.toString();
    }

}
