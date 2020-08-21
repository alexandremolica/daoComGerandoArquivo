package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.EspecificacaoMaterialPermanenteDao;
import model.entities.EspecificacaoMaterialPermanente;

public class EspecificacaoMaterialPermanenteDaoJDBC implements EspecificacaoMaterialPermanenteDao{
	private Connection conn;

	
	public EspecificacaoMaterialPermanenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public EspecificacaoMaterialPermanente findBySequencialBemEOrgao(String sqBemPerm, String cdOrgao) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String modelo = null;
		String marca = null;
		String serie = null;
		String especificacao = "";
		
		List<EspecificacaoMaterialPermanente> list = new ArrayList<>();
		
		try {
			st = conn.prepareStatement(

					
					"SELECT   DS_COMPLETA\r\n" + 
							"       , CD_CARACTERISTICA\r\n" + 
							"       , NM_CARACTERISTICA\r\n" + 
							"       , DS_CAR_NUMBER\r\n" + 
							"       , NM_CARACT_TAB\r\n" + 
							"       , DS_CAR_CHAR\r\n" + 
							"FROM SIGINPI.BP_V_DS_COMPLETA\r\n" + 
							"WHERE  BP_V_DS_COMPLETA.SQ_BEM_PERM = ? \r\n" + 
							"AND    BP_V_DS_COMPLETA.CD_ORGAO = ? \r\n" + 
							"ORDER BY BP_V_DS_COMPLETA.NR_ORDEM");

			st.setString(1, sqBemPerm);
			st.setString(2, cdOrgao);

			rs = st.executeQuery();

			String auxiliar;
			
			while (rs.next()) {
				auxiliar = "";
				
				if (rs.getString("NM_CARACT_TAB") != null) {
					auxiliar = rs.getString("NM_CARACT_TAB")+" ";
				}
				/*
				if (rs.getString("DS_CAR_CHAR")!= null) {
					auxiliar += rs.getString("DS_CAR_CHAR")+" ";
				}
				*/
				if (rs.getString("DS_CAR_NUMBER") != null) {
					auxiliar += rs.getString("DS_CAR_CHAR")+" ";
				}
				if(!auxiliar.equals("") ){
					especificacao += rs.getString("NM_CARACTERISTICA") + " "+ auxiliar+ " ";
				}

				
				if (rs.getString("NM_CARACTERISTICA").contentEquals("MARCA") && !auxiliar.equals("") ) {
					marca =  rs.getString("NM_CARACTERISTICA") +" " +auxiliar; 

				}else if (rs.getString("NM_CARACTERISTICA").contentEquals("SERIE") && !auxiliar.equals("") ) {
					serie =  rs.getString("NM_CARACTERISTICA") +" " +auxiliar; 

					
				}else if (rs.getString("NM_CARACTERISTICA").contentEquals("MODELO") && !auxiliar.equals("") ) {
					modelo =  rs.getString("NM_CARACTERISTICA") +" " +auxiliar; 
					
				};

					
			}
			if (especificacao.equals("") ) {
				especificacao = "SEM ESPECIFICACAO - CAMPO OBRIGARTORIO";
			}

			EspecificacaoMaterialPermanente obj = instantiateEspecificacaoMaterialPermanente( marca, serie, modelo ,especificacao );
			return obj;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage() );
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private EspecificacaoMaterialPermanente instantiateEspecificacaoMaterialPermanente
			(String marca, String serie, String modelo , String especificacao) {
		EspecificacaoMaterialPermanente obj = new EspecificacaoMaterialPermanente();

		obj.setMarca(marca);
		obj.setSerie(serie);
		obj.setModelo(modelo);
		obj.setEspecificacao(especificacao);
		
		return obj;
	}
	
}
