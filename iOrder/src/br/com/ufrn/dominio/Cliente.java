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
@Table(name="Cliente")
public class Cliente implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_CLIENTE", initialValue=1,
	allocationSize=1, sequenceName="seq_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@Column(name="id_Cliente")
	private int id;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
