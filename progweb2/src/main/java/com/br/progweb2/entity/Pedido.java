package com.br.progweb2.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue
    @Column(name = "id_pedido", nullable = false)
	private String id;
	
	@Column(name = "nome_cliente", length = 200, nullable = false)
	private String nomeCliente;
	
	@Column(name = "descricao", length = 400)
	private String descricao;
	
	@DateTimeFormat
	@Column(name = "data", nullable = false)
	private Date data;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_vendedor", referencedColumnName = "id_vendedor", nullable = false)
	private Vendedor vendedor;
	
	@Column(name = "data", nullable = false)
	private float precoTotal;

	@ManyToMany
	@JoinTable(name="pedido_produto", joinColumns=
			{@JoinColumn(name="id_pedido")}, inverseJoinColumns=
			{@JoinColumn(name="id_produto")})
	private List<Produto> produtos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"id='" + id + '\'' +
				", nomeCliente='" + nomeCliente + '\'' +
				", descricao='" + descricao + '\'' +
				", data=" + data +
				", vendedor=" + vendedor +
				", precoTotal=" + precoTotal +
				'}';
	}
}
