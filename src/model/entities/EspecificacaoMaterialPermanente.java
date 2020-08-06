package model.entities;

import java.io.Serializable;

public class EspecificacaoMaterialPermanente implements Serializable{
	private static final long serialVersionUID = 1L;

	private String especificacao;
	private String modelo;
	private String marca;
	private String serie;
	
	public EspecificacaoMaterialPermanente() {};
	
	public EspecificacaoMaterialPermanente(String especificacao, String modelo, String marca, String serie) {
		this.especificacao = especificacao;
		this.modelo = modelo;
		this.marca = marca;
		this.serie = serie;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especificacao == null) ? 0 : especificacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EspecificacaoMaterialPermanente other = (EspecificacaoMaterialPermanente) obj;
		if (especificacao == null) {
			if (other.especificacao != null)
				return false;
		} else if (!especificacao.equals(other.especificacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "especificacao=" + especificacao 
				+ ", modelo=" + modelo 
				+ ", marca=" + marca 
				+ ", serie=" + serie;
	}
	
}
