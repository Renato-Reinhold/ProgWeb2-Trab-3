package com.br.progweb2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_pedido", referencedColumnName = "id_pedido")
	private Pedido pedido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_produto", referencedColumnName = "id_produto")
	private Produto produto;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
