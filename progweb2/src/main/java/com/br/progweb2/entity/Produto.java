package com.br.progweb2.entity;

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
	private String id;
	
    @Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
    @Column(name = "descricao", length = 400)
	private String descricao;
	
    @Column(name = "preco", nullable = false)
	private float preco;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Produto{" +
				"id='" + id + '\'' +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", preco=" + preco +
				'}';
	}
}
