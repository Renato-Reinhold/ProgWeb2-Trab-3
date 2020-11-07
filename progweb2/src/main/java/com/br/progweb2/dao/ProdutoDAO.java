package com.br.progweb2.dao;

import com.br.progweb2.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @Autowired
    private EntityManager entityManager;

    public List list(){
        try {
            String sql = " Select p.id, p.nome, p.descricao, p.preco from " + Produto.class.getName() + " p order by p.nome";
            Query query = this.entityManager.createQuery(sql, String.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Produto get(String id){
        try {
            return entityManager.find(Produto.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Produto update(Produto produto){
        try {
            return entityManager.merge(produto);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(Produto produto){
        try {
            entityManager.remove(produto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


}
