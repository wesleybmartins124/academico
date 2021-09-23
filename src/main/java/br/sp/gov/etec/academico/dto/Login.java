package br.sp.gov.etec.academico.dto;

import javax.validation.constraints.NotBlank;

public class Login {
	@NotBlank(message = "Informe um usuário")
	private String usuario;
	
	@NotBlank(message = "Informe uma senha")
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
