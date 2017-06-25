package br.com.ufrn.negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufrn.dao.GenericDAO;
import br.com.ufrn.dominio.ItemCardapio;
import br.com.ufrn.dominio.ItemDeCardapio;
import br.com.ufrn.dominio.Pedido;


@Named(value = "orderController")
@RequestScoped
public class CadastroPedidoMBean {
	
	@Inject GenericDAO dao;
	
	private Pedido pedido;
	private ItemCardapio item;
		

	public CadastroPedidoMBean() {
		this.pedido = new Pedido();
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String addNewItem() {
		dao.addNew(item);
		//itemList = dao.findEmployees();
		return "employeelist";
	}
	
	public void addItem(ItemCardapio item) {
		pedido.addItem(item);
	}
	
	public void removeItem(ItemCardapio item) {
		pedido.removeItem(item);
	}
}
