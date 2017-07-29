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
import fr.GPAssocies.entities.DetailsDevis;
import fr.GPAssocies.entities.Devis;

@Repository("detailsDevisDao")
public class DetailsDevisDaoImpl extends DaoImpl<DetailsDevis> implements DetailsDevisDao {
	private final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<DetailsDevis> findByDevis(Devis devis) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(DetailsDevis.class);
			cri.add(Restrictions.eq("devis", devis));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findByDevis: Devis:" + devis + " list:" + cri.list());
		return cri.list();
	}

}
