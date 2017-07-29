package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

/**
 * @author Paul
 * @param FactureMois
 */
public interface FactureMoisDao extends Dao<FactureMois> {
    /**
     * @param FactureMois
     * @return List
     */
	List<FactureMois> findAll();
	
    /**
     * @param MC
     * @return FactureMois
     */
	FactureMois findParMC(String MC);
    
    /**
     * @param statut
     */
    boolean statutFactMois(FactureMois factureMois);
    
    List<FactureMois> findByFactG(FactureGlobal factureGlobal);
    
    List<Reglement> findReglementByFactureMois(FactureMois factureMois);
}
