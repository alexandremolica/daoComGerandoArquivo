package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.EspecificacaoMaterialPermanenteDao;
import model.dao.MaterialPermanenteDao;
import model.entities.EspecificacaoMaterialPermanente;
import model.entities.MaterialPermanente;

public class MaterialPermanenteDaoJDBC implements MaterialPermanenteDao {
	Scanner sc = new Scanner(System.in);

	private Connection conn;

	public MaterialPermanenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<MaterialPermanente> findAll(){
	//	PreparedStatement st = null;
		List<MaterialPermanente> list = new ArrayList<>();
		Statement st = null;
 		ResultSet rs = null;
		
		try {
	
			st = conn.createStatement();
			
			rs = st.executeQuery(
					"SELECT   \r\n" + 
					"         BP_BEM.SQ_BEM_PERM \r\n" + 
					"        ,SUBSTR(CR_BEM_SERVICO.DS_COMPLETA,1,300) DS_COMPLETA\r\n" + 
					"        ,BP_BEM.CD_CONTA\r\n" + 
					"        ,BP_BEM.CD_ORGAO CODIGO_UORG\r\n" + 
					"        ,SUBSTR(CR_UA.SG_UA||'-'||\r\n" + 
					"                CR_LOCALIZ.NM_LOCAL_COMPLETO||'-'||\r\n" + 
					"                CR_INSTALACAO.DS_ENDERECO||' - '||\r\n" + 
					"                CR_INSTALACAO.NM_BAIRRO||' - '|| \r\n" + 
					"                CR_INSTALACAO.CD_CIDADE||' - '||  \r\n" + 
					"                CR_INSTALACAO.NR_CEP||' - '|| \r\n" + 
					"                CR_INSTALACAO.NM_INSTALACAO,1,50) ENDERECO_MATERIAL\r\n" + 
					"        ,DECODE(BP_TP_OPERACAO.CD_TP_OPERACAO,'02','2','1') TIPO\r\n" + 
					"        ,CASE TRIM(NM_TP_SIT_FISICA)\r\n" + 
					"            WHEN 'NOVO' THEN '1'\r\n" + 
					"            WHEN 'BOM' THEN '1'\r\n" + 
					"            WHEN 'REGULAR' THEN '1'\r\n" + 
					"            WHEN 'RECUPERÁVEL' THEN '2'\r\n" + 
					"            WHEN 'IRRECUPERÁVEL' THEN '3'\r\n" + 
					"            WHEN 'INSERVÍVEL' THEN '3'\r\n" + 
					"            WHEN 'OCIOSO' THEN '4'\r\n" + 
					"            WHEN 'ANTI-ECONOMICO' THEN '5'\r\n" + 
					"            ELSE '2'\r\n" + 
					"         END SITUACAO\r\n" + 
					"        ,'1' TIPO_PLAQUETA   \r\n" + 
					"        ,TO_CHAR(BP_ENTRADA.DT_CONTABIL, 'DD')||TO_CHAR(BP_ENTRADA.DT_CONTABIL, 'MM')||TO_CHAR(BP_ENTRADA.DT_CONTABIL,'YYYY') DATA_TOMBAMENTO\r\n" + 
					"        ,BP_BEM.VL_UNITARIO\r\n" + 
					"        ,'NAO ENCONTRADO ???????   'FORMA_AQUISICAO\r\n" + 
					"        ,'ESPECIFICACAO TEM QUE FAZER FORA SQL TRAZ MAIS 1 LINHA ????' ESPECIFICACAO\r\n" + 
					"        ,BP_BEM.CD_BEM_PERM PATRIMONIO\r\n" + 
					"        ,BP_BEM.CD_ORGAO\r\n" + 
					"        ,CR_UG.CD_UG\r\n" + 
					"        ,CR_UG.NM_UG\r\n" + 
					"        ,CR_UG.SG_UG\r\n" + 
					"        ,BP_BEM.CD_BEM_PERM\r\n" + 
					"        ,BP_BEM.CD_PATR_ANTIGO\r\n" + 
					"        ,CR_BEM_SERVICO.NM_BEM_SERVICO\r\n" + 
					"        ,BP_TP_SIT_FISICA.NM_TP_SIT_FISICA\r\n" + 
					"        ,BP_ENTRADA.DT_AQUISICAO\r\n" + 
					"        ,BP_BEM.SQ_BEM_PERM\r\n" + 
					" FROM    SIGINPI.BP_BEM\r\n" + 
					"       ,SIGINPI.CR_BEM_SERVICO\r\n" + 
					"       ,SIGINPI.BP_TP_STATUS\r\n" + 
					"       ,SIGINPI.BP_ENTRADA\r\n" + 
					"       ,SIGINPI.BP_TP_SIT_FISICA \r\n" + 
					"       ,SIGINPI.CR_UG\r\n" + 
					"       ,SIGINPI.CR_CONTA\r\n" + 
					"       ,SIGINPI.CR_UL\r\n" + 
					"       ,SIGINPI.CR_UA\r\n" + 
					"       ,SIGINPI.CR_LOCALIZ\r\n" + 
					"       ,SIGINPI.CR_INSTALACAO\r\n" + 
					"       ,SIGINPI.BP_TP_OPERACAO\r\n" + 
					"WHERE BP_BEM.CD_BEM_SERVICO     = CR_BEM_SERVICO.CD_BEM_SERVICO \r\n" + 
					"AND BP_BEM.CD_TP_STATUS         = BP_TP_STATUS.CD_TP_STATUS\r\n" + 
					"AND BP_BEM.CD_ORGAO             = BP_ENTRADA.CD_ORGAO     \r\n" + 
					"AND BP_BEM.CD_ENTRADA           = BP_ENTRADA.CD_ENTRADA   \r\n" + 
					"AND BP_BEM.CD_UG                = BP_ENTRADA.CD_UG        \r\n" + 
					"AND BP_BEM.CD_TP_SIT_FISICA     = BP_TP_SIT_FISICA.CD_TP_SIT_FISICA \r\n" + 
					"AND BP_BEM.CD_ORGAO             = CR_UG.CD_ORGAO\r\n" + 
					"AND BP_BEM.CD_UG                = CR_UG.CD_UG\r\n" + 
					"AND CR_BEM_SERVICO.CD_CONTA     = CR_CONTA.CD_CONTA\r\n" + 
					"AND BP_BEM.CD_ORGAO             = CR_UL.CD_ORGAO\r\n" + 
					"AND BP_BEM.CD_UL_ATUAL          = CR_UL.CD_UL\r\n" + 
					"AND CR_UL.CD_ORGAO              = CR_UA.CD_ORGAO\r\n" + 
					"AND CR_UL.CD_UA                 = CR_UA.CD_UA\r\n" + 
					"AND CR_UL.CD_ORGAO              = CR_LOCALIZ.CD_ORGAO\r\n" + 
					"AND CR_UL.CD_LOCAL              = CR_LOCALIZ.CD_LOCAL\r\n" + 
					"AND CR_LOCALIZ.CD_ORGAO         = CR_INSTALACAO.CD_ORGAO\r\n" + 
					"AND CR_LOCALIZ.CD_INSTALACAO    = CR_INSTALACAO.CD_INSTALACAO\r\n" + 
					"AND BP_ENTRADA.CD_TP_OPERACAO   = BP_TP_OPERACAO.CD_TP_OPERACAO\r\n" + 
					"AND NOT EXISTS (SELECT NULL FROM SIGINPI.BP_ENT_DOC \r\n" + 
					"                WHERE BP_ENTRADA.CD_ENTRADA = BP_ENT_DOC.CD_ENTRADA\r\n" + 
					"                AND BP_ENTRADA.CD_UG        = BP_ENT_DOC.CD_UG\r\n" + 
					"                AND BP_ENTRADA.CD_ORGAO     = BP_ENT_DOC.CD_ORGAO)\r\n" + 
					"AND BP_BEM.CD_CONTA             = '123110101'\r\n" + 
					"AND CR_CONTA.CD_SISTEMA         = 'PA'\r\n" + 
					"AND BP_BEM.DT_BAIXA             IS NULL\r\n" + 
					"AND BP_BEM.CD_UG                = '183038'\r\n" + 
					"\r\n" + 
					"UNION\r\n" + 
					"\r\n" + 
					"SELECT   \r\n" + 
					"         BP_BEM.SQ_BEM_PERM\r\n" + 
					"        ,SUBSTR(CR_BEM_SERVICO.DS_COMPLETA,1,300) DS_COMPLETA\r\n" + 
					"        ,BP_BEM.CD_CONTA\r\n" + 
					"        ,BP_BEM.CD_ORGAO CODIGO_UORG\r\n" + 
					"        ,SUBSTR(CR_UA.SG_UA||'-'||\r\n" + 
					"                CR_LOCALIZ.NM_LOCAL_COMPLETO||'-'||\r\n" + 
					"                CR_INSTALACAO.DS_ENDERECO||' - '||\r\n" + 
					"                CR_INSTALACAO.NM_BAIRRO||' - '|| \r\n" + 
					"                CR_INSTALACAO.CD_CIDADE||' - '||  \r\n" + 
					"                CR_INSTALACAO.NR_CEP||' - '|| \r\n" + 
					"                CR_INSTALACAO.NM_INSTALACAO,1,50) ENDERECO_MATERIAL\r\n" + 
					"        ,DECODE(BP_TP_OPERACAO.CD_TP_OPERACAO,'02','2','1') TIPO\r\n" + 
					"        ,CASE TRIM(NM_TP_SIT_FISICA)\r\n" + 
					"            WHEN 'NOVO' THEN '1'\r\n" + 
					"            WHEN 'BOM' THEN '1'\r\n" + 
					"            WHEN 'REGULAR' THEN '1'\r\n" + 
					"            WHEN 'RECUPERÁVEL' THEN '2'\r\n" + 
					"            WHEN 'IRRECUPERÁVEL' THEN '3'\r\n" + 
					"            WHEN 'INSERVÍVEL' THEN '3'\r\n" + 
					"            WHEN 'OCIOSO' THEN '4'\r\n" + 
					"            WHEN 'ANTI-ECONOMICO' THEN '5'\r\n" + 
					"            ELSE '2'\r\n" + 
					"         END SITUACAO\r\n" + 
					"        ,'1' TIPO_PLAQUETA   \r\n" + 
					"        ,TO_CHAR(BP_ENTRADA.DT_CONTABIL, 'DD')||TO_CHAR(BP_ENTRADA.DT_CONTABIL, 'MM')||TO_CHAR(BP_ENTRADA.DT_CONTABIL,'YYYY') DATA_TOMBAMENTO\r\n" + 
					"        ,BP_BEM.VL_UNITARIO\r\n" + 
					"        ,BP_ENT_DOC.NR_DOCUMENTO||'-'||CR_TP_DOCUMENTO.NM_TP_DOCUMENTO FORMA_AQUISICAO\r\n" + 
					"        ,'ESPECIFICACAO TEM QUE FAZER FORA SQL TRAZ MAIS 1 LINHA' ESPECIFICACAO\r\n" + 
					"        ,BP_BEM.CD_BEM_PERM PATRIMONIO\r\n" + 
					"        ,BP_BEM.CD_ORGAO\r\n" + 
					"        ,CR_UG.CD_UG\r\n" + 
					"        ,CR_UG.NM_UG\r\n" + 
					"        ,CR_UG.SG_UG\r\n" + 
					"        ,BP_BEM.CD_BEM_PERM\r\n" + 
					"        ,BP_BEM.CD_PATR_ANTIGO\r\n" + 
					"        ,CR_BEM_SERVICO.NM_BEM_SERVICO\r\n" + 
					"        ,BP_TP_SIT_FISICA.NM_TP_SIT_FISICA\r\n" + 
					"        ,BP_ENTRADA.DT_AQUISICAO\r\n" + 
					"        ,BP_BEM.SQ_BEM_PERM\r\n" + 
					" FROM    SIGINPI.BP_BEM\r\n" + 
					"       ,SIGINPI.CR_BEM_SERVICO\r\n" + 
					"       ,SIGINPI.BP_TP_STATUS\r\n" + 
					"       ,SIGINPI.BP_ENTRADA\r\n" + 
					"       ,SIGINPI.BP_TP_SIT_FISICA \r\n" + 
					"       ,SIGINPI.CR_UG\r\n" + 
					"       ,SIGINPI.CR_CONTA\r\n" + 
					"       ,SIGINPI.CR_UL\r\n" + 
					"       ,SIGINPI.CR_UA\r\n" + 
					"       ,SIGINPI.CR_LOCALIZ\r\n" + 
					"       ,SIGINPI.CR_INSTALACAO\r\n" + 
					"       ,SIGINPI.BP_TP_OPERACAO\r\n" + 
					"       ,SIGINPI.BP_ENT_DOC\r\n" + 
					"       ,SIGINPI.CR_TP_DOCUMENTO\r\n" + 
					"WHERE BP_BEM.CD_BEM_SERVICO     = CR_BEM_SERVICO.CD_BEM_SERVICO \r\n" + 
					"AND BP_BEM.CD_TP_STATUS         = BP_TP_STATUS.CD_TP_STATUS\r\n" + 
					"AND BP_BEM.CD_ORGAO             = BP_ENTRADA.CD_ORGAO     \r\n" + 
					"AND BP_BEM.CD_ENTRADA           = BP_ENTRADA.CD_ENTRADA   \r\n" + 
					"AND BP_BEM.CD_UG                = BP_ENTRADA.CD_UG        \r\n" + 
					"AND BP_BEM.CD_TP_SIT_FISICA     = BP_TP_SIT_FISICA.CD_TP_SIT_FISICA \r\n" + 
					"AND BP_BEM.CD_ORGAO             = CR_UG.CD_ORGAO\r\n" + 
					"AND BP_BEM.CD_UG                = CR_UG.CD_UG\r\n" + 
					"AND CR_BEM_SERVICO.CD_CONTA     = CR_CONTA.CD_CONTA\r\n" + 
					"AND BP_BEM.CD_ORGAO             = CR_UL.CD_ORGAO\r\n" + 
					"AND BP_BEM.CD_UL_ATUAL          = CR_UL.CD_UL\r\n" + 
					"AND CR_UL.CD_ORGAO              = CR_UA.CD_ORGAO\r\n" + 
					"AND CR_UL.CD_UA                 = CR_UA.CD_UA\r\n" + 
					"AND CR_UL.CD_ORGAO              = CR_LOCALIZ.CD_ORGAO\r\n" + 
					"AND CR_UL.CD_LOCAL              = CR_LOCALIZ.CD_LOCAL\r\n" + 
					"AND CR_LOCALIZ.CD_ORGAO         = CR_INSTALACAO.CD_ORGAO\r\n" + 
					"AND CR_LOCALIZ.CD_INSTALACAO    = CR_INSTALACAO.CD_INSTALACAO\r\n" + 
					"AND BP_ENTRADA.CD_TP_OPERACAO   = BP_TP_OPERACAO.CD_TP_OPERACAO\r\n" + 
					"AND BP_ENTRADA.CD_ENTRADA       = BP_ENT_DOC.CD_ENTRADA \r\n" + 
					"AND BP_ENTRADA.CD_UG            = BP_ENT_DOC.CD_UG\r\n" + 
					"AND BP_ENTRADA.CD_ORGAO         = BP_ENT_DOC.CD_ORGAO\r\n" + 
					"AND BP_ENT_DOC.CD_TP_DOCUMENTO  = CR_TP_DOCUMENTO.CD_TP_DOCUMENTO\r\n" + 
					"AND BP_ENT_DOC.CD_TP_DOCUMENTO = '002'\r\n" + 
					"AND BP_BEM.CD_CONTA             = '123110101'\r\n" + 
					"AND CR_CONTA.CD_SISTEMA         = 'PA'\r\n" + 
					"AND BP_BEM.DT_BAIXA             IS NULL\r\n" + 
					"AND BP_BEM.CD_UG                = '183038'\r\n"
					
					
					);
			
			while (rs.next()) {
				
				MaterialPermanente obj = instantiateMaterialPermanente(rs);	
				list.add(obj);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	

	private MaterialPermanente instantiateMaterialPermanente(ResultSet rs) throws SQLException {
		MaterialPermanente obj = new MaterialPermanente();
		EspecificacaoMaterialPermanenteDao especificacaoMPDao = new DaoFactory().createEspecificacaoMaterialPermanenteDao();
		EspecificacaoMaterialPermanente objEspec;

		obj.setCodigoMaterial(rs.getString("SQ_BEM_PERM"));
		obj.setDescricao(rs.getString("DS_COMPLETA"));
		obj.setCodigoConta(rs.getString("CD_CONTA"));
		obj.setUorg(rs.getString("CODIGO_UORG"));
		obj.setEnderecoLocalizacaoMaterial(rs.getString("ENDERECO_MATERIAL"));
		obj.setTipo(rs.getString("TIPO"));
		obj.setSituacao(rs.getString("SITUACAO"));
		obj.setTipoPlaqueta(rs.getString("TIPO_PLAQUETA"));
		obj.setDataTombamento(rs.getString("DATA_TOMBAMENTO"));
		obj.setValorBem(rs.getString("VL_UNITARIO"));
		obj.setFormaDeAquisicao(rs.getString("FORMA_AQUISICAO"));
		obj.setEspecificacao(rs.getString("ESPECIFICACAO"));
		obj.setPatrimonio(rs.getString("PATRIMONIO"));
		obj.setCodigoUg(rs.getString("CD_UG"));
		//tratando especificacao, marca, serie e modelo
		objEspec = especificacaoMPDao.findBySequencialBemEOrgao(rs.getString("SQ_BEM_PERM"), rs.getString("CODIGO_UORG"));
		obj.setEspecificacao(objEspec.getEspecificacao());
		obj.setMarca(objEspec.getMarca());
		obj.setModelo(objEspec.getModelo());
		obj.setNumSerie(objEspec.getSerie());
		
		return obj;
	}
	
	private List<String> getEspecificacao(String sqBemPerm, String cdOrgao ) {
		return null;
	}
	
}
