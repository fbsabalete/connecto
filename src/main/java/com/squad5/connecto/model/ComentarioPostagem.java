package com.squad5.connecto.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_comentario_postagem")
public class ComentarioPostagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties(value = {"postagem", "comentario"})
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties(value = {"usuario", "comentario"})
    private Postagem postagem;

    @NotNull
    @Size(max = 9999)
    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date(System.currentTimeMillis());


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}


