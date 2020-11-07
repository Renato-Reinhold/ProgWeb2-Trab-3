package org.o7planning.sbsecurity.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue
    @Column(name = "id_pedido", nullable = false)
	private Integer id;
	
	@Column(name = "nome_cliente", length = 200, nullable = false)
	private String nomeCliente;
	
	@Column(name = "descricao", length = 400, nullable = true)
	private String descricao;
	
	@DateTimeFormat
	@Column(name = "data", nullable = false)
	private Date data;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_vendedor", referencedColumnName = "id_vendedor", nullable = false)
	private Vendedor vendedor;
	
	@Column(name = "data", nullable = false)
	private float precoTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
}
