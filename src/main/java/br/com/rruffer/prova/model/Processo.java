package br.com.rruffer.prova.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROCESSO")
public class Processo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_INT_ID_PROCESSO")
	private Long id;
	
	
	@Column(name = "PRO_STR_DS_PROCESSO")
	private String pub;

	@Column(name = "PRO_INT_PED_INTERNACIONAL")
	private String pedidoInternacional;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "PRO_DAT_DT_PUBLICACAO")
	private Date dataPublicacao;

	@OneToMany(mappedBy = "requerente")
	private Set<Requerente> requerentes;

	@Column(name = "PRO_STR_DS_TITULO")
	private String titulo;

	public Processo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public String getPedidoInternacional() {
		return pedidoInternacional;
	}

	public void setPedidoInternacional(String pedidoInternacional) {
		this.pedidoInternacional = pedidoInternacional;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Requerente> getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(Set<Requerente> requerentes) {
		this.requerentes = requerentes;
	}

}
