package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;

import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

public interface FactureGService {
	/**
     * create factureGlobal
     * @param factureGlobal 
     */
    void create(FactureGlobal factureGlobal);
    
    /**
     * update factureGlobal
     * @param factureGlobal 
     */
    void update(FactureGlobal factureGlobal);
    
    /**
     * delete factureGlobal
     * @param factureGlobal 
     */
    void delete(FactureGlobal factureGlobal);

    /**
     * @param tauxTva
     * @param montantHt
     * @return montantTtc
     */
	double calculmontantTtc(double montantHt, double tauxTva);

    /**
     * @param String
     * @return LocalDate
     */
	LocalDate strToDate(String dateStr);

    /**
     * @param LocalDate
     * @return String
     */
	String dateToStr(LocalDate date);
	
	/**
     * @param FactureGlobal
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
    List<FactureGlobal> findByClient(Client client);
    List<FactureMois> findByFactG(FactureGlobal factureGlobal);
    FactureGlobal findByDevis(Devis devis);
}
