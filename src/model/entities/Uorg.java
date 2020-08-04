package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Uorg implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uorg;
	private String ugVinculada;
	private String nome;
	private String sigla;
	private String endereco;
	private String cep;
	private String ddd;
	private String telefone;
	private String ramal;
	private String fax;
	private String cpfDoResponsavel;
	private String nomeDoResponsavel;
	private String matriculaSIAPE;
	private String numeroDaPortariaDeNomeacao;
	private String codigoDaUorgSubordinada;
	private String nomeReduzido;
	private String dataDaCriacao;
	private String numeroDoDocumentoDeCriacao;
	private String siglaDaUf;
	private String municipio;
	private String email;

	public Uorg() {

	}

	public Uorg(String uorg, String ugVinculada, String nome, String sigla, String endereco, String cep, String ddd,
			String telefone, String ramal, String fax, String cpfDoResponsavel, String nomeDoResponsavel,
			String matriculaSIAPE, String numeroDaPortariaDeNomeacao, String codigoDaUorgSubordinada,
			String nomeReduzido, String dataDaCriacao, String numeroDoDocumentoDeCriacao, String siglaDaUf,
			String municipio, String email) {
		this.uorg = uorg;
		this.ugVinculada = ugVinculada;
		this.nome = nome;
		this.sigla = sigla;
		this.endereco = endereco;
		this.cep = cep;
		this.ddd = ddd;
		this.telefone = telefone;
		this.ramal = ramal;
		this.fax = fax;
		this.cpfDoResponsavel = cpfDoResponsavel;
		this.nomeDoResponsavel = nomeDoResponsavel;
		this.matriculaSIAPE = matriculaSIAPE;
		this.numeroDaPortariaDeNomeacao = numeroDaPortariaDeNomeacao;
		this.codigoDaUorgSubordinada = codigoDaUorgSubordinada;
		this.nomeReduzido = nomeReduzido;
		this.dataDaCriacao = dataDaCriacao;
		this.numeroDoDocumentoDeCriacao = numeroDoDocumentoDeCriacao;
		this.siglaDaUf = siglaDaUf;
		this.municipio = municipio;
		this.email = email;
	}

	public String getUorg() {
		return uorg;
	}

	public void setUorg(String uorg) {
		this.uorg = uorg;
	}

	public String getUgVinculada() {
		return ugVinculada;
	}

	public void setUgVinculada(String ugVinculada) {
		this.ugVinculada = ugVinculada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCpfDoResponsavel() {
		return cpfDoResponsavel;
	}

	public void setCpfDoResponsavel(String cpfDoResponsavel) {
		this.cpfDoResponsavel = cpfDoResponsavel;
	}

	public String getNomeDoResponsavel() {
		return nomeDoResponsavel;
	}

	public void setNomeDoResponsavel(String nomeDoResponsavel) {
		this.nomeDoResponsavel = nomeDoResponsavel;
	}

	public String getMatriculaSIAPE() {
		return matriculaSIAPE;
	}

	public void setMatriculaSIAPE(String matriculaSIAPE) {
		this.matriculaSIAPE = matriculaSIAPE;
	}

	public String getNumeroDaPortariaDeNomeacao() {
		return numeroDaPortariaDeNomeacao;
	}

	public void setNumeroDaPortariaDeNomeacao(String numeroDaPortariaDeNomeacao) {
		this.numeroDaPortariaDeNomeacao = numeroDaPortariaDeNomeacao;
	}

	public String getCodigoDaUorgSubordinada() {
		return codigoDaUorgSubordinada;
	}

	public void setCodigoDaUorgSubordinada(String codigoDaUorgSubordinada) {
		this.codigoDaUorgSubordinada = codigoDaUorgSubordinada;
	}

	public String getNomeReduzido() {
		return nomeReduzido;
	}

	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}

	public String getDataDaCriacao() {
		return dataDaCriacao;
	}

	public void setDataDaCriacao(String dataDaCriacao) {
		this.dataDaCriacao = dataDaCriacao;
	}

	public String getNumeroDoDocumentoDeCriacao() {
		return numeroDoDocumentoDeCriacao;
	}

	public void setNumeroDoDocumentoDeCriacao(String numeroDoDocumentoDeCriacao) {
		this.numeroDoDocumentoDeCriacao = numeroDoDocumentoDeCriacao;
	}

	public String getSiglaDaUf() {
		return siglaDaUf;
	}

	public void setSiglaDaUf(String siglaDaUf) {
		this.siglaDaUf = siglaDaUf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uorg == null) ? 0 : uorg.hashCode());
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
		Uorg other = (Uorg) obj;
		if (uorg == null) {
			if (other.uorg != null)
				return false;
		} else if (!uorg.equals(other.uorg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uorg [uorg=" + uorg + ", ugVinculada=" + ugVinculada + ", nome=" + nome + ", sigla=" + sigla
				+ ", endereco=" + endereco + ", cep=" + cep + ", ddd=" + ddd + ", telefone=" + telefone + ", ramal="
				+ ramal + ", fax=" + fax + ", cpfDoResponsavel=" + cpfDoResponsavel + ", nomeDoResponsavel="
				+ nomeDoResponsavel + ", matriculaSIAPE=" + matriculaSIAPE + ", numeroDaPortariaDeNomeacao="
				+ numeroDaPortariaDeNomeacao + ", codigoDaUorgSubordinada=" + codigoDaUorgSubordinada
				+ ", nomeReduzido=" + nomeReduzido + ", dataDaCriacao=" + dataDaCriacao
				+ ", numeroDoDocumentoDeCriacao=" + numeroDoDocumentoDeCriacao + ", siglaDaUf=" + siglaDaUf
				+ ", municipio=" + municipio + ", email=" + email + "]";
	}

}
