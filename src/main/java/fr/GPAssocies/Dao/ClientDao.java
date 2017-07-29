package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;

/**
 * @author Paul
 * @param Client
 */
public interface ClientDao extends Dao<Client> {
    /**
     * @param Client
     * @return List
     */
	List<Client> findAll();
	
    /**
     * @param MC
     * @return Client
     */
    Client findParMC(String MC);
    
    /**
     * @param statut
     */
    boolean statut(Client client);
    
    /**
     * @param Client
     * @return List
     */
	List<Devis> findDevisByClient(Client client);
	
	/**
     * @param Client
     * @return List
     */
	List<FactureGlobal> findFactGByClient(Client client);
}
