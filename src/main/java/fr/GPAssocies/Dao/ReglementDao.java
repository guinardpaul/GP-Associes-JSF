package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

public interface ReglementDao extends Dao<Reglement> {
	Reglement findbyId(int id);
	List<Reglement> findReglementByFactureMois(FactureMois factureMois);
}
