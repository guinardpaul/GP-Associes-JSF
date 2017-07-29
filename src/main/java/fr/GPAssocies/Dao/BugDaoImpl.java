package fr.GPAssocies.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.GPAssocies.Util.DaoImpl;
import fr.GPAssocies.entities.Bug;

@Repository("bugDao")
public class BugDaoImpl extends DaoImpl<Bug> implements BugDao {
	private final Logger logger = LoggerFactory.getLogger(BugDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Bug> findAll() {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Bug.class);
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findAll:" + cri.list());
		return cri.list();
	}

}
