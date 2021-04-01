package com.squad5.connecto.model;


public class UsuarioLogin {

	private long id;
    private String nomeCompleto;
    private String fotoPerfil;
    private String email;
    private String senha;
    private String token;
    private String tipoAdmin;
    
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getTipoAdmin() {
		return tipoAdmin;
	}

	public void setTipoAdmin(String tipoAdmin) {
		this.tipoAdmin = tipoAdmin;
	}

	
}
