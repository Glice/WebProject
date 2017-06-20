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
@Table(name="Mesa")
public class Mesa implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_MESA", initialValue=1,
	allocationSize=1, sequenceName="seq_mesa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MESA")
	@Column(name="id_Mesa")
	private int id;

}
