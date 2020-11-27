package com.progweb.programacaoweb.controller;


import com.progweb.programacaoweb.dao.PedidoDAO;
import com.progweb.programacaoweb.model.Pedido;
import com.progweb.programacaoweb.model.Produto;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoServicoController {

    @Autowired
    private PedidoDAO pedidoDAO;

    @GetMapping
    public List<Pedido> Get() {
        return pedidoDAO.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> GetById(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = pedidoDAO.findById(id);
        if(pedido.isPresent()){
            return new ResponseEntity<>(pedido.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object> Post(@RequestBody Pedido pedido) {
        Pedido newProduto = pedidoDAO.save(pedido);
        if(newProduto != null){
            return new ResponseEntity<>("Pedido criado com sucesso!!", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedido> Put(@PathVariable("id") Long id, @RequestBody Pedido newPedido) {
        Optional<Pedido> oldPedido = pedidoDAO.findById(id);
        if(oldPedido.isPresent()){
            Pedido pedido = oldPedido.get();
            pedido.setNomeCliente(newPedido.getNomeCliente());
            pedido.setDescricao(newPedido.getDescricao());
            pedido.setData(newPedido.getData());
            pedido.setVendedor(newPedido.getVendedor());
            pedidoDAO.save(pedido);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = pedidoDAO.findById(id);
        if(pedido.isPresent()){
            pedidoDAO.delete(pedido.get());
            return new ResponseEntity<>("Pedido deletado com sucesso!!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/precoTotal/{id}")
    public ResponseEntity<Object> GetPrecoTotalByPedido(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = pedidoDAO.findById(id);
        if(pedido.isPresent()){
            JSONObject object = new JSONObject();
            object.put("id", pedido.get().getId());
            float precoTotal = 0;
            for (Produto produto: pedido.get().getProdutos()){
                precoTotal += produto.getPreco();
            }
            object.put("precoTotal", precoTotal);
            return new ResponseEntity<>(object, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/produtoPorPedido/{id}")
    public ResponseEntity<Object> GetProdutosByPedido(@PathVariable("id") Long id) {
        Pedido pedido = pedidoDAO.getOne(id);
        JSONObject object = new JSONObject();
        object.put("id", pedido.getId());
        object.put("produtos", pedido.getProdutos());
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

}
