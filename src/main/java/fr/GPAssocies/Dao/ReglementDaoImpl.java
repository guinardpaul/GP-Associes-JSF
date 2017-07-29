package fr.GPAssocies.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.GPAssocies.Util.DaoImpl;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

@Repository("reglementDao")
public class ReglementDaoImpl extends DaoImpl<Reglement> implements ReglementDao {
	private final Logger logger = LoggerFactory.getLogger(ReglementDaoImpl.class);

	public Reglement findbyId(int id) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Reglement.class);
			cri.add(Restrictions.eq("idReglement", id));
		} catch (HibernateException he) {
			logger.error("Error" + he);
		}
		logger.info("findById:" + (Reglement) cri.uniqueResult());
		return (Reglement) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Reglement> findReglementByFactureMois(FactureMois factureMois) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Reglement.class);
			cri.add(Restrictions.eq("factureMois", factureMois));
		} catch (HibernateException he) {
			logger.error("Error" + he);
		}
		logger.info("findReglementByFactureMois:" + cri.list());
		return cri.list();
	}

}
