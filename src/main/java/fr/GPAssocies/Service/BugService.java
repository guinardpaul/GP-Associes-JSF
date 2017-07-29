package fr.GPAssocies.Service;

import java.util.List;

import fr.GPAssocies.entities.Bug;

public interface BugService {
	/**
     * create bug
     * @param bug 
     */
    void create(Bug bug);
    
    /**
     * update bug
     * @param bug 
     */
    void update(Bug bug);
    
    /**
     * delete bug
     * @param bug 
     */
    void delete(Bug bug);
    List<Bug> findAll();

}
