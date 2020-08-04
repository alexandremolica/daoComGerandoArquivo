package model.entities;

import java.io.Serializable;

public class MaterialPermanente implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String codigoMaterial; 
	private String descricao;
	private String codigoConta;
	private String enderecoLocalizacaoMaterial; 
	private String uorg;
	private String tipo;
	private String situacao; 
	private String tipoPlaqueta; 
	private String dataTombamento;
	private String valorBem;
	private String formaDeAquisicao;
	private String especificacao;
	private String dataDevolucao;
	private String numSerie;
	private String patrimonio;
	private String marca;
	private String modelo;
	private String garantidor;
	private String numContrato;
	private String inicioGarantia;
	private String fimGarantia;
	private String cpfCorresponsavel;
	private String nomeCorresponsavel;
	private String emAlmoxarifado;
	private String dataReavaliacao;
	private String valorReavaliacao;
	private String vidaUtil; 
	private String codigoUg;
	private String fabricante;
	
	public MaterialPermanente() {}

	public MaterialPermanente(String codigoMaterial, String descricao, String codigoConta,
			String enderecoLocalizacaoMaterial, String uorg, String tipo, String situacao, String tipoPlaqueta,
			String dataTombamento, String valorBem, String formaDeAquisicao, String especificacao, String dataDevolucao,
			String numSerie, String patrimonio, String marca, String modelo, String garantidor, String numContrato,
			String inicioGarantia, String fimGarantia, String cpfCorresponsavel, String nomeCorresponsavel,
			String emAlmoxarifado, String dataReavaliacao, String valorReavaliacao, String vidaUtil, String codigoUg, String fabricante) {
		super();
		this.codigoMaterial = codigoMaterial;
		this.descricao = descricao;
		this.codigoConta = codigoConta;
		this.enderecoLocalizacaoMaterial = enderecoLocalizacaoMaterial;
		this.uorg = uorg;
		this.tipo = tipo;
		this.situacao = situacao;
		this.tipoPlaqueta = tipoPlaqueta;
		this.dataTombamento = dataTombamento;
		this.valorBem = valorBem;
		this.formaDeAquisicao = formaDeAquisicao;
		this.especificacao = especificacao;
		this.dataDevolucao = dataDevolucao;
		this.numSerie = numSerie;
		this.patrimonio = patrimonio;
		this.marca = marca;
		this.modelo = modelo;
		this.garantidor = garantidor;
		this.numContrato = numContrato;
		this.inicioGarantia = inicioGarantia;
		this.fimGarantia = fimGarantia;
		this.cpfCorresponsavel = cpfCorresponsavel;
		this.nomeCorresponsavel = nomeCorresponsavel;
		this.emAlmoxarifado = emAlmoxarifado;
		this.dataReavaliacao = dataReavaliacao;
		this.valorReavaliacao = valorReavaliacao;
		this.vidaUtil = vidaUtil;
		this.codigoUg = codigoUg;
		this.fabricante = fabricante;
	}

	public String getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(String codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getEnderecoLocalizacaoMaterial() {
		return enderecoLocalizacaoMaterial;
	}

	public void setEnderecoLocalizacaoMaterial(String enderecoLocalizacaoMaterial) {
		this.enderecoLocalizacaoMaterial = enderecoLocalizacaoMaterial;
	}

	public String getUorg() {
		return uorg;
	}

	public void setUorg(String uorg) {
		this.uorg = uorg;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipoPlaqueta() {
		return tipoPlaqueta;
	}

	public void setTipoPlaqueta(String tipoPlaqueta) {
		this.tipoPlaqueta = tipoPlaqueta;
	}

	public String getDataTombamento() {
		return dataTombamento;
	}

	public void setDataTombamento(String dataTombamento) {
		this.dataTombamento = dataTombamento;
	}

	public String getValorBem() {
		return valorBem;
	}

	public void setValorBem(String valorBem) {
		this.valorBem = valorBem;
	}

	public String getFormaDeAquisicao() {
		return formaDeAquisicao;
	}

	public void setFormaDeAquisicao(String formaDeAquisicao) {
		this.formaDeAquisicao = formaDeAquisicao;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getGarantidor() {
		return garantidor;
	}

	public void setGarantidor(String garantidor) {
		this.garantidor = garantidor;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getInicioGarantia() {
		return inicioGarantia;
	}

	public void setInicioGarantia(String inicioGarantia) {
		this.inicioGarantia = inicioGarantia;
	}

	public String getFimGarantia() {
		return fimGarantia;
	}

	public void setFimGarantia(String fimGarantia) {
		this.fimGarantia = fimGarantia;
	}

	public String getCpfCorresponsavel() {
		return cpfCorresponsavel;
	}

	public void setCpfCorresponsavel(String cpfCorresponsavel) {
		this.cpfCorresponsavel = cpfCorresponsavel;
	}

	public String getNomeCorresponsavel() {
		return nomeCorresponsavel;
	}

	public void setNomeCorresponsavel(String nomeCorresponsavel) {
		this.nomeCorresponsavel = nomeCorresponsavel;
	}

	public String getEmAlmoxarifado() {
		return emAlmoxarifado;
	}

	public void setEmAlmoxarifado(String emAlmoxarifado) {
		this.emAlmoxarifado = emAlmoxarifado;
	}

	public String getDataReavaliacao() {
		return dataReavaliacao;
	}

	public void setDataReavaliacao(String dataReavaliacao) {
		this.dataReavaliacao = dataReavaliacao;
	}

	public String getValorReavaliacao() {
		return valorReavaliacao;
	}

	public void setValorReavaliacao(String valorReavaliacao) {
		this.valorReavaliacao = valorReavaliacao;
	}

	public String getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(String vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public String getCodigoUg() {
		return codigoUg;
	}

	public void setCodigoUg(String codigoUg) {
		this.codigoUg = codigoUg;
	};

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoMaterial == null) ? 0 : codigoMaterial.hashCode());
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
		MaterialPermanente other = (MaterialPermanente) obj;
		if (codigoMaterial == null) {
			if (other.codigoMaterial != null)
				return false;
		} else if (!codigoMaterial.equals(other.codigoMaterial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "codigoMaterial=" + codigoMaterial + ", descricao=" + descricao + ", codigoConta="
				+ codigoConta + ", enderecoLocalizacaoMaterial=" + enderecoLocalizacaoMaterial + ", uorg=" + uorg
				+ ", tipo=" + tipo + ", situacao=" + situacao + ", tipoPlaqueta=" + tipoPlaqueta + ", dataTombamento="
				+ dataTombamento + ", valorBem=" + valorBem + ", formaDeAquisicao=" + formaDeAquisicao
				+ ", especificacao=" + especificacao + ", dataDevolucao=" + dataDevolucao + ", numSerie=" + numSerie
				+ ", patrimonio=" + patrimonio + ", marca=" + marca + ", modelo=" + modelo + ", garantidor="
				+ garantidor + ", numContrato=" + numContrato + ", inicioGarantia=" + inicioGarantia + ", fimGarantia="
				+ fimGarantia + ", cpfCorresponsavel=" + cpfCorresponsavel + ", nomeCorresponsavel="
				+ nomeCorresponsavel + ", emAlmoxarifado=" + emAlmoxarifado + ", dataReavaliacao=" + dataReavaliacao
				+ ", valorReavaliacao=" + valorReavaliacao + ", vidaUtil=" + vidaUtil + "codigoUg="+ codigoUg ;
	}



}
