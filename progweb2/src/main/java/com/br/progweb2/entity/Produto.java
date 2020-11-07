package org.o7planning.sbsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
    @GeneratedValue
    @Column(name = "id_produto", nullable = false)
	private Integer id;
	
    @Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
    @Column(name = "descricao", length = 400, nullable = true)
	private String descricao;
	
    @Column(name = "preco", nullable = false)
	private float preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
