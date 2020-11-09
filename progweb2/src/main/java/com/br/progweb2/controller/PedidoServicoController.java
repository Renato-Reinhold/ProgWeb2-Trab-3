package com.br.progweb2.controller;

import com.br.progweb2.dao.PedidoDAO;
import com.br.progweb2.entity.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PedidoServicoController {

    private static Map<String, Pedido> pedidos = new HashMap<>();
    private static final PedidoDAO PEDIDO_DAO = PedidoDAO.getInstance();

    @RequestMapping(value = "/pedidos")
    public ResponseEntity<Object> getPedido() {
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPedidod(@PathVariable("id") String id) {
        return new ResponseEntity<>(pedidos.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos", method = RequestMethod.POST)
    public ResponseEntity<Object> createPedido(@RequestBody Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        PEDIDO_DAO.insert(pedido);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePedido(@PathVariable("id") String id, @RequestBody Pedido pedido) {
        pedidos.remove(id);
        pedido.setId(id);
        pedidos.put(id, pedido);
        PEDIDO_DAO.update(pedido);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/pedidos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        pedidos.remove(id);
        PEDIDO_DAO.delete(id);
        return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
    }

    public String showPedidos() { return pedidos.toString(); }

    private void populateMap() {
        List<Pedido> pedidos = PedidoDAO.getInstance().list();
        for (Pedido pedido : pedidos) {
            this.pedidos.put(pedido.getId(), pedido);
        }
    }

}
