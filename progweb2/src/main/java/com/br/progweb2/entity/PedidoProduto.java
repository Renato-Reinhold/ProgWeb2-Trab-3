//package com.br.progweb2.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "pedido_produto")
//public class PedidoProduto {
//
//	@Id
//	@GeneratedValue
//	@Column(name = "id")
//	private String id;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_pedido", referencedColumnName = "id_pedido")
//	private Pedido pedido;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_produto", referencedColumnName = "id_produto")
//	private Produto produto;
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public Pedido getPedido() {
//		return pedido;
//	}
//
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
//
//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//	}
//
//}
