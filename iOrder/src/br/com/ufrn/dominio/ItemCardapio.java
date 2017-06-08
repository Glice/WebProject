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
	@SequenceGenerator(name="SEQ_USUARIO", initialValue=1,
	allocationSize=1, sequenceName="seq_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@Column(name="id_Usuario")
	private int id;

}
