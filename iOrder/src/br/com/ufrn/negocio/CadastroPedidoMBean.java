package br.com.ufrn.negocio;

import javax.faces.bean.ManagedBean;

import br.com.ufrn.dominio.ItemDeCardapio;
import br.com.ufrn.dominio.Pedido;

@ManagedBean
public class CadastroPedidoMBean {
	private Pedido pedido;
	

	public CadastroPedidoMBean() {
		
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void addItem(ItemDeCardapio item) {
		pedido.getItens().add(item);
	}
	
	public void removeItem(ItemDeCardapio item) {
		pedido.getItens().remove(item);
	}
}
