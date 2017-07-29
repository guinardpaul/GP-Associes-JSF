package fr.GPAssocies.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.GPAssocies.Util.DaoImpl;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

/**
 * @author Paul
 * @param FactureMois
 */
@Repository("factureMoisDao")
public class FactureMoisDaoImpl extends DaoImpl<FactureMois> implements FactureMoisDao {
	private final Logger logger = LoggerFactory.getLogger(FactureMoisDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<FactureMois> findAll() {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureMois.class);
		} catch (HibernateException he) {
			logger.error("Error: " + he);
		}
		logger.info("findAll:" + cri.list());
		return cri.list();
	}

	public FactureMois findParMC(String MC) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureMois.class);
			cri.add(Restrictions.ilike("ref", "%" + MC + "%"));
		} catch (HibernateException he) {
			logger.error("Error: " + he);
		}
		logger.info("findByMC: MC:" + MC + " List: " + (FactureMois) cri.uniqueResult());
		return (FactureMois) cri.uniqueResult();
	}

	public boolean statutFactMois(FactureMois factureMois) {
		List<Reglement> reglements = new ArrayList<Reglement>();
		try{
			reglements = findReglementByFactureMois(factureMois);
		} catch (Exception e) {
			logger.error("Error :" + e);
		}
		
		int somme = 0;
		for (Reglement r : reglements) {
			somme += r.getReglementTtc();
		}
		
		if (factureMois.getMontantFacture() == somme) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FactureMois> findByFactG(FactureGlobal factureGlobal) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureMois.class);
			cri.add(Restrictions.eq("factureGlobal", factureGlobal));
		} catch (HibernateException he) {
			logger.error("Error: " + he);
		}
		logger.info("findByFactG: FactG:" + factureGlobal + " List: " + cri.list());
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	public List<Reglement> findReglementByFactureMois(FactureMois factureMois) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureMois.class);
			cri.add(Restrictions.eq("factureMois", factureMois));
		} catch (HibernateException he) {
			logger.error("Error: " + he);
		}
		logger.info("findByFactG: FactG:" + factureMois + " List: " + cri.list());
		return cri.list();
	}

}
