package fr.GPAssocies.Service;

import java.util.List;

import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

public interface ReglementService {
	void create(Reglement reglement);
	void update(Reglement reglement);
	void delete(Reglement reglement);
	Reglement findbyId(int id);
	List<Reglement> findReglementByFactureMois(FactureMois factureMois);

}
