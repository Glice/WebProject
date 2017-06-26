package br.com.ufrn.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
	
	@Id
	@SequenceGenerator(name="SEQ_PEDIDO", initialValue=1,
	allocationSize=1, sequenceName="seq_PEDIDO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDO")
	@Column(name="id_Pedido")
	private int id;
	
	private List<ItemCardapio> itens;
	private double valor;
	private Cliente cliente;
	private Mesa mesa;
	
	public Pedido(Mesa mesa) {
		this.cliente = new Cliente();
		this.cliente.setNome("Cliente não identificado");
		this.mesa = mesa;
	}
	
	public Pedido() {
		this.cliente = new Cliente();
		this.cliente.setNome("Cliente não identificado");
		//this.mesa = mesa;
		this.itens = new ArrayList<ItemCardapio>();
	}

	public double totalPedido() {
		for (ItemCardapio item : itens) {
			this.valor += item.getValor();
		}
		
		return this.valor;
	}
	
	public List<ItemCardapio> getItens() {
		return itens;
	}

	public void setItens(List<ItemCardapio> itens) {
		this.itens = itens;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public void addItem(ItemCardapio item) {
		this.itens.add(item);
	}
	
	public void removeItem(ItemCardapio item) {
		this.itens.remove(item);
	}

}
