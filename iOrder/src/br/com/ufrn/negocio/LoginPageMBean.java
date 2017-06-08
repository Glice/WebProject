package br.com.ufrn.negocio;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginPageMBean {

	private String login;
	private String INDEX_PAGE = "Index";

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
