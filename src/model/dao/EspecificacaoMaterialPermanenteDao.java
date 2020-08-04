package model.dao;

import java.util.List;

import model.entities.EspecificacaoMaterialPermanente;

public interface EspecificacaoMaterialPermanenteDao {

	EspecificacaoMaterialPermanente findBySequencialBemEOrgao(String sqBemPerm, String cdOrgao );

}
