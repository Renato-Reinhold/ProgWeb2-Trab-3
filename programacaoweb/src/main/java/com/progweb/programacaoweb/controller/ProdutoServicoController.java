package com.progweb.programacaoweb.controller;


import com.progweb.programacaoweb.dao.ProdutoDAO;
import com.progweb.programacaoweb.model.Produto;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoServicoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping
    public List<Produto> Get() {
        return produtoDAO.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> GetById(@PathVariable("id") Long id) {
        Optional<Produto> produto = produtoDAO.findById(id);
        System.out.println(produto.get());
        if(produto.isPresent()){
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> Post(@RequestBody Produto produto) {
        Produto newProduto = produtoDAO.save(produto);
        if(newProduto != null){
            return new ResponseEntity<>("Produto Criado com sucesso!!", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> Put(@PathVariable("id") Long id, @RequestBody Produto newProduto) {
        Optional<Produto> oldProduto = produtoDAO.findById(id);
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            produto.setNome(newProduto.getNome());
            produto.setDescricao(newProduto.getDescricao());
            produto.setPreco(newProduto.getPreco());
            produtoDAO.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
        Optional<Produto> produto = produtoDAO.findById(id);
        if(produto.isPresent()){
            produtoDAO.delete(produto.get());
            return new ResponseEntity<>("Produto deletado com sucesso!!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/pedidosPorProduto")
    public ResponseEntity<Object> GetPedidosByProdutos() {
        List<Produto> produtos = produtoDAO.findAll();
        JSONArray jsonArray = new JSONArray();
        for (Produto produto : produtos){
            JSONObject object = new JSONObject();
            object.put("id", produto.getId());
            object.put("pedidos", produto.getPedidos().toArray());
            jsonArray.add(object);
        }
        return new ResponseEntity<>(jsonArray, HttpStatus.OK);
    }

    @GetMapping(value = "/pedidosPorProduto/{id}")
    public ResponseEntity<Object> GetPedidosByProduto(@PathVariable("id") Long id) {
        Optional<Produto> produto = produtoDAO.findById(id);
        JSONObject object = new JSONObject();
        object.put("id", produto.get().getId());
        object.put("pedidos", produto.get().getPedidos().toArray());
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

}
