package fr.GPAssocies.Util;

import org.joda.time.LocalDate;

/**
 * @author Paul
 * IDao(CRUD)
 * @param <T>
 */
public interface Dao<T> {
    /**
     * create obj
     * @param obj 
     */
    void create(T obj);
    
    /**
     * update obj
     * @param obj 
     */
    void update(T obj);
    
    /**
     * delete obj
     * @param obj 
     */
    void delete(T obj);

    /**
     * @param value
     * @return double
     */
    public double round(double value);
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
}
