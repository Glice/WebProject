package br.com.ufrn.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sun.java.swing.plaf.windows.resources.windows;

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
	private List<ItemCardapio> itensMenu = new ArrayList<>();
	private List<String> itensSelecionados = new ArrayList<>();
		

	public CadastroPedidoMBean() {
		// pegar do banco:
		// itensMenu = itens_no_Banco
		for (int i=1; i<=5; i++) {
			this.item = new ItemCardapio();
			this.item.setId(i);
			this.item.setNome("Item" + i);
			this.itensMenu.add(item);
		}
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
	
	public void addItem() {
		this.itensMenu.add(item);
		pedido.addItem(this.item);
		this.item = null;
	}
	
	public void removeItem(ItemCardapio item) {
		pedido.removeItem(item);
		this.itensMenu.remove(item);
	}
	
	public void listarItens(){
		ItemCardapioDAO itemDAO = new ItemCardapioDAO();
		try {
			this.setItensMenu(itemDAO.findAll());
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

	/*public List<ItemCardapio> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemCardapio> itemList) {
		this.itemList = itemList;
	}*/
	
	public List<ItemCardapio> getItensMenu() {
		return itensMenu;
	}

	public void setItensMenu(List<ItemCardapio> itensMenu) {
		this.itensMenu = itensMenu;
	}

	public List<String> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<String> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
	
	
	public String enviarPedido(){
		/*for (String id : itensSelecionados) {
//			this.dao.inserir(item);
			ItemCardapio item = itensMenu
			pedido.addItem(item);
		}*/
		
		return "Index.xhtml";
	}
	
}
