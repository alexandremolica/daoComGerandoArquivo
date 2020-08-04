package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UorgDao;
import model.entities.Uorg;

public class UorgDaoJDBC implements UorgDao {
	private Connection conn;

	
	public UorgDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Uorg findByUorg(String uorg) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName " 
							+ "FROM seller "
					+ "INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id " 
					+ "WHERE seller.Id = ?");
			
			st.setString(1, uorg);

			rs = st.executeQuery();

			if (rs.next()) {
				Uorg obj = instantiateUorg(rs);	
				return obj;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}	

	private Uorg instantiateUorg(ResultSet rs) throws SQLException {
		Uorg obj = new Uorg();

		obj.setUorg(rs.getString("uorg"));
		obj.setUgVinculada(rs.getString("ugVinculada"));
		obj.setNome(rs.getString("nome"));
		obj.setSigla(rs.getString("sigla"));
		obj.setEndereco(rs.getString("endereco"));
		obj.setCep(rs.getString("cep"));
		obj.setDdd(rs.getString("ddd"));
		obj.setTelefone(rs.getString("telefone"));
		obj.setRamal(rs.getString("ramal"));
		obj.setFax(rs.getString("fax"));
		obj.setCpfDoResponsavel(rs.getString("cpfDoResponsavel"));
		obj.setNomeDoResponsavel(rs.getString("nomeDoResponsavel"));
		obj.setMatriculaSIAPE(rs.getString("matriculaSIAPE"));
		obj.setNumeroDaPortariaDeNomeacao(rs.getString("numeroDaPortariaDeNomeacao"));
		obj.setCodigoDaUorgSubordinada(rs.getString("codigoDaUorgSubordinada"));
		obj.setNomeReduzido(rs.getString("nomeReduzido"));
		obj.setDataDaCriacao(rs.getString("dataDaCriacao"));
		obj.setNumeroDoDocumentoDeCriacao(rs.getString("numeroDoDocumentoDeCriacao"));
		obj.setSiglaDaUf(rs.getString("siglaDaUf"));
		obj.setMunicipio(rs.getString("municipio"));
		obj.setEmail(rs.getString("email"));
		
		return obj;
	}
}
