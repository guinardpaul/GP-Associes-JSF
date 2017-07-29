package fr.GPAssocies.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.BugDao;
import fr.GPAssocies.entities.Bug;

@Service("bugService")
public class BugServiceImpl implements BugService {
	@Autowired
	private BugDao bugDao;
	public void setBugDao(BugDao bugDao) {
		this.bugDao = bugDao;
	}

	@Transactional
	public void create(Bug bug) {
		bugDao.create(bug);
	}
	
	@Transactional
	public void update(Bug bug) {
		bugDao.update(bug);
	}
	
	@Transactional
	public void delete(Bug bug) {
		bugDao.delete(bug);
	}
	
	@Transactional
	public List<Bug> findAll() {
		return bugDao.findAll();
	}

}
