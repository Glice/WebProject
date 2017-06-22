package br.com.ufrn.negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
		itemList = dao.findEmployees();
		return "employeelist";
	}
	
	public void addItem(ItemDeCardapio item) {
		pedido.getItens().add(item);
	}
	
	public void removeItem(ItemDeCardapio item) {
		pedido.getItens().remove(item);
	}
}

@Named(value = "employeeController")
@RequestScoped
public class EmployeeMB {
	@Inject EmployeeDAO dao;
	
	//Auxiliary fields for JSF
	private List<Employee> employeeList = new ArrayList<>();
	private Employee employee = new Employee();
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addNewEmployee() {
		dao.addNew(employee);
		employeeList = dao.findEmployees();
		return "employeelist";
	}