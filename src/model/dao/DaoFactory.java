package model.dao;

import db.DB;
import model.dao.impl.EspecificacaoMaterialPermanenteDaoJDBC;
import model.dao.impl.MaterialPermanenteDaoJDBC;
import model.dao.impl.UorgDaoJDBC;

public class DaoFactory {
	
	public static UorgDao createUorgDao() {
		return new UorgDaoJDBC(DB.getConnection());
	}

	
	 public static MaterialPermanenteDao createMaterialPermanenteDao() {
		return new MaterialPermanenteDaoJDBC(DB.getConnection());
	}

	 public static EspecificacaoMaterialPermanenteDao createEspecificacaoMaterialPermanenteDao() {
		return new EspecificacaoMaterialPermanenteDaoJDBC(DB.getConnection());
	}
	 
}
