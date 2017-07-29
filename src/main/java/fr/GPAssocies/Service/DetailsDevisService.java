package fr.GPAssocies.Service;

import java.util.List;

import fr.GPAssocies.entities.DetailsDevis;
import fr.GPAssocies.entities.Devis;

public interface DetailsDevisService {
	/**
     * create DetailsDevis
     * @param detailsDevis 
     */
    void create(DetailsDevis detailsDevis);
    
    /**
     * update DetailsDevis
     * @param detailsDevis 
     */
    void update(DetailsDevis detailsDevis);
    
    /**
     * delete DetailsDevis
     * @param detailsDevis 
     */
    void delete(DetailsDevis detailsDevis);
    
	List<DetailsDevis> findByDevis(Devis devis);
}
