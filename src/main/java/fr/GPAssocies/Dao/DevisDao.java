package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;

/**
 *
 * @author Paul
 * @param Devis
 */
public interface DevisDao extends Dao<Devis> {
    /**
     * @return List
     */
	List<Devis> findAll();
	
    /**
     * @param MC
     * @return Devis
     */
	Devis findParMC(String MC);
	
	/**
     * @param id
     * @return Devis
     */
	Devis findById(int id);
	
	/**
     * @param client
     * @return List
     */
	List<Devis> findByClient(Client client);
	
	
}
