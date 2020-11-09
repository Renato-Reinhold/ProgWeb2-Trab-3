package com.br.progweb2.dao;

import com.br.progweb2.entity.Pedido;
import com.br.progweb2.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PedidoDAO {

    @Autowired
    private EntityManager entityManager;

    private static PedidoDAO instance;

    public static PedidoDAO getInstance(){
        if (instance == null){
            instance = new PedidoDAO();
        }
        return instance;
    }

    public List list(){
        try {
            String sql = " Select p.id, p.nomeCliente, p.descricao, p.data, p.vendedor from " + Pedido.class.getName() + " p order by p.id";
            Query query = this.entityManager.createQuery(sql, String.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Pedido get(String id){
        try {
            return entityManager.find(Pedido.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(Pedido pedido){
        try {
            entityManager.persist(pedido);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Pedido update(Pedido pedido){
        try {
            return entityManager.merge(pedido);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(String id){
        try {
            entityManager.remove(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


}
