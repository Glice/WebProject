package br.com.ufrn.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ufrn.dao.GenericDAO;
import br.com.ufrn.dao.ItemCardapioDAO;
import br.com.ufrn.dominio.ItemCardapio;
import br.com.ufrn.dominio.Pedido;


@ManagedBean(name = "orderController")
@RequestScoped
public class CadastroPedidoMBean {
	
	@Inject GenericDAO dao;
	
	private final String PedidoForm = "Formulario.xhtml";
	private Pedido pedido = new Pedido();
	private ItemCardapio item = new ItemCardapio();
	// Itens que na tela de seleção
	private List<ItemCardapio> itemList = new ArrayList<>();
	
//	private List<ItemCardapio> itensSelecionados = new ArrayList<>(); // necessário?
		

	public CadastroPedidoMBean() {
		
		this.item.setId(1);
		this.item.setNome("item teste");
	}

	public ItemCardapio getItem() {
		return item;
	}

	public void setItem(ItemCardapio item) {
		this.item = item;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
//	public String addNewItem() {
//		dao.addNew(item);
//		//itemList = dao.findEmployees();
//		return "itens";
//	}
	
	public void addItem(ItemCardapio item) {
		pedido.addItem(item);
	}
	
	public void removeItem(ItemCardapio item) {
		pedido.removeItem(item);
	}
	
	public void listarItens(){
		ItemCardapioDAO itemDAO = new ItemCardapioDAO();
		try {
			this.setItemList(itemDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String confirmarSelecao(){
		for (ItemCardapio item : this.pedido.getItens()) {
			dao.addNew(item);	
		}
		
		return "URL_de_confirmacao";
	}

	public List<ItemCardapio> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemCardapio> itemList) {
		this.itemList = itemList;
	}
	
	public String criarPedido(){
		return PedidoForm;
	}
	
}
