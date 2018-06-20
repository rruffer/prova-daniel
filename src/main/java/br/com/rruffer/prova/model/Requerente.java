package br.com.rruffer.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REQUERENTE")
public class Requerente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REQ_INT_ID_REQUERENTE")
	private Long id;
	
	@Column(name="REQ_STR_DS_REQUERENTE")
	private String requerente;

	@ManyToOne
	@JoinColumns({@JoinColumn(name = "PRO_INT_ID_PROCESSO", referencedColumnName = "PRO_INT_ID_PROCESSO")})
	private Processo processo;
	
	
	public Requerente() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getRequerente() {
		return requerente;
	}

	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}
	
	
	
}
