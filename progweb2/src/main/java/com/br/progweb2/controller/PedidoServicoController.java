package com.br.progweb2.controller;

import com.br.progweb2.entity.Pedido;
import com.br.progweb2.entity.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PedidoServicoController {

    private static Map<String, Pedido> pedidos = new HashMap<>();

    @RequestMapping(value = "/pedidos")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(@PathVariable("id") String id) {
        return new ResponseEntity<>(pedidos.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Pedido produto) {
        pedidos.put(produto.getId(), produto);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Pedido produto) {
        pedidos.remove(id);
        produto.setId(id);
        pedidos.put(id, produto);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        pedidos.remove(id);
        return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
    }

    public String showPedidos(){
        return pedidos.toString();
    }

}
