package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;

import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

public interface FactureMoisService {
	/**
     * create factureMois
     * @param factureMois 
     */
    void create(FactureMois factureMois);
    
    /**
     * update factureMois
     * @param factureMois 
     */
    void update(FactureMois factureMois);
    
    /**
     * delete factureMois
     * @param factureMois 
     */
    void delete(FactureMois factureMois);

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
}
