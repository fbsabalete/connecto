package com.squad5.connecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_postagem")
public class 	Postagem
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 3000)
	private String descricaoPost;
	
	@Size(min = 10, max = 500)
	private String linkImagem;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	private boolean prestadorServicos;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	@OneToMany
	@JsonIgnoreProperties("postagem")
	private List<ComentarioPostagem> comentario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescricaoPost() {
		return descricaoPost;
	}

	public void setDescricaoPost(String descricaoPost) {
		this.descricaoPost = descricaoPost;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPrestadorServicos() {
		return prestadorServicos;
	}

	public void setPrestadorServicos(boolean prestadorServicos) {
		this.prestadorServicos = prestadorServicos;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioPostagem> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioPostagem> comentario) {
		this.comentario = comentario;
	}
}
