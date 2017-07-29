package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

/**
 * @author Paul
 * @param FactureGlobal
 */
public interface FactureGDao extends Dao<FactureGlobal> {
    /**
     * @return List
     */
	List<FactureGlobal> findAll();
	
    /**
     * @param MC
     * @return FactureGlobal
     */
	FactureGlobal findParMC(String MC);
    
    /**
     * @param FactureGlobal
     */
    boolean statutFactGlobal(FactureGlobal factureGlobal);
    
    /**
     * @param factureGlobal
     * @return List
     */
	List<FactureMois> findFactMByFactG(FactureGlobal factureGlobal);
	
	/**
     * @param client
     * @return List
     */
	List<FactureGlobal> findByClient(Client client);
	
	FactureGlobal findByDevis(Devis devis);
}
