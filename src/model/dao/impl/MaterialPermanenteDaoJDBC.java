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
import model.dao.MaterialPermanenteDao;
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
		//	DB.closeConnection();
		}
	}	

	private MaterialPermanente instantiateMaterialPermanente(ResultSet rs) throws SQLException {
		MaterialPermanente obj = new MaterialPermanente();

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
		
		
		return obj;
	}
	
}
