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
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;

@Repository("devisDao")
public class DevisDaoImpl extends DaoImpl<Devis> implements DevisDao {
	private final Logger logger = LoggerFactory.getLogger(DevisDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Devis> findAll() {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Devis.class);
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findAllDevis:" + cri.list());
		return cri.list();
	}

	public Devis findParMC(String MC) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Devis.class);
			cri.add(Restrictions.ilike("ref", "%" + MC + "%"));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findParMC: MC:" + MC + " Devis: " + (Devis) cri.uniqueResult());
		return (Devis) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Devis> findByClient(Client client) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Devis.class);
			cri.add(Restrictions.eq("client", client));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findDevisByClient: Client:" + client + " List: " + cri.list());
		return cri.list();
	}

	public Devis findById(int id) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Devis.class);
			cri.add(Restrictions.eq("id_devFact", id));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findById: Id:" + id + " Devis: " + (Devis) cri.uniqueResult());
		return (Devis) cri.uniqueResult();
	}

}
