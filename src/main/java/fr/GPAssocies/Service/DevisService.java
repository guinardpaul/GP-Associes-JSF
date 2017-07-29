package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;

import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;

public interface DevisService {
	/**
     * create devis
     * @param devis 
     */
    void create(Devis devis);
    
    /**
     * update devis
     * @param devis 
     */
    void update(Devis devis);
    
    /**
     * delete devis
     * @param devis 
     */
    void delete(Devis devis);

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
     * @param Devis
     * @return List
     */
	List<Devis> findAll();
	
    /**
     * @param MC
     * @return Devis
     */
	Devis findParMC(String MC);
	List<Devis> findByClient(Client client);
	Devis findById(int id);
	
}
