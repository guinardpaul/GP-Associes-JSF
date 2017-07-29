package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.DetailsDevis;
import fr.GPAssocies.entities.Devis;

public interface DetailsDevisDao extends Dao<DetailsDevis> {
	List<DetailsDevis> findByDevis(Devis devis);
}
