package fr.GPAssocies.Dao;

import java.util.List;

import fr.GPAssocies.Util.Dao;
import fr.GPAssocies.entities.Bug;

public interface BugDao extends Dao<Bug> {
	List<Bug> findAll();

}
