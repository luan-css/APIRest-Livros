package com.gft.socialbooks.handler;

public class DetalhesErro {
	private String titulo;
	private Long status;
	private Long timestamp;
	private String mensagemdesenvolvedor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagemdesenvolvedor() {
		return mensagemdesenvolvedor;
	}

	public void setMensagemdesenvolvedor(String mensagemdesenvolvedor) {
		this.mensagemdesenvolvedor = mensagemdesenvolvedor;
	}

}
