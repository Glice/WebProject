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
@Table(name="ItemCardapio")
public class ItemCardapio implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_ITEM_CARDAPIO", initialValue=1,
	allocationSize=1, sequenceName="seq_item_cardapio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_CARDAPIO")
	@Column(name="id_Usuario")
	private int id;
	
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
