package br.com.ufrn.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_FUNCIONARIO", initialValue=1,
	allocationSize=1, sequenceName="seq_funcionario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
	@Column(name="id_Funcionario")
	private int id;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
