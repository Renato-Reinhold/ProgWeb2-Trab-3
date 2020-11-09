package com.br.progweb2.dao;

import com.br.progweb2.entity.Produto;
import com.br.progweb2.entity.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class VendedorDAO {

    @Autowired
    private EntityManager entityManager;

    private static VendedorDAO instance;

    public static VendedorDAO getInstance(){
        if (instance == null){
            instance = new VendedorDAO();
        }
        return instance;
    }

    public List list(){
        try {
            String sql = " Select v.id, v.nome, v.email, v.senha from " + Vendedor.class.getName() + " v order by v.nome";
            Query query = this.entityManager.createQuery(sql, String.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Vendedor get(String id){
        try {
            return entityManager.find(Vendedor.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(Vendedor vendedor){
        try {
            entityManager.persist(vendedor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Vendedor update(Vendedor vendedor){
        try {
            return entityManager.merge(vendedor);
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
