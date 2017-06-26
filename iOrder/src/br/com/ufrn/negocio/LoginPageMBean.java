package br.com.ufrn.negocio;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "loginPageMBean")
public class LoginPageMBean {

	private String login;
	private String INDEX_PAGE = "Index.xhtml";

	public LoginPageMBean() {
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String logar() {
		return INDEX_PAGE;
	}
	
}
