package fr.GPAssocies.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.GPAssocies.Util.DaoImpl;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

@Repository("factureGDao")
public class FactureGDaoImpl extends DaoImpl<FactureGlobal> implements FactureGDao {
	private final Logger logger = LoggerFactory.getLogger(FactureGDaoImpl.class);

	@Autowired
	private FactureMoisDao factureMoisDao;

	@SuppressWarnings("unchecked")
	public List<FactureGlobal> findAll() {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureGlobal.class);
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findAllFactG:" + cri.list());
		return cri.list();
	}

	public FactureGlobal findParMC(String MC) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureGlobal.class);
			cri.add(Restrictions.ilike("ref", "%" + MC + "%"));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findByMC: MC " + MC + " List: " + (FactureGlobal) cri.uniqueResult());
		return (FactureGlobal) cri.uniqueResult();
	}

	public boolean statutFactGlobal(FactureGlobal factureGlobal) {
		double somme = 0;
		List<FactureMois> factureMois = new ArrayList<FactureMois>();
		List<Reglement> reglements = new ArrayList<Reglement>();
		try {
			factureMois = findFactMByFactG(factureGlobal);
		} catch (Exception e) {
			logger.error("Error :" + e);
		}

		if (factureMois != null) {
			for (FactureMois f : factureMois) {
				try {
					reglements = factureMoisDao.findReglementByFactureMois(f);
				} catch (Exception e) {
					logger.error("Error :" + e);
				}
				
				if (reglements.isEmpty()) {
					logger.info("FactureMois sans réglement " + f);
				} else {
					for (Reglement r : reglements) {
						somme += r.getReglementTtc();
					}
				}
			}
		}

		if (factureGlobal.getMontantTTC() == somme) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FactureMois> findFactMByFactG(FactureGlobal factureGlobal) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureMois.class);
			cri.add(Restrictions.eq("factureGlobal", factureGlobal));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findFactGByClient: FactG:" + factureGlobal + " List: " + cri.list());
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	public List<FactureGlobal> findByClient(Client client) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureGlobal.class);
			cri.add(Restrictions.eq("client", client));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findByClient: Client:" + client + " List: " + cri.list());
		return cri.list();
	}

	public FactureGlobal findByDevis(Devis devis) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureGlobal.class);
			cri.add(Restrictions.eq("devis", devis));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findByDevis: Devis:" + devis + " FactG: " + (FactureGlobal) cri.uniqueResult());
		return (FactureGlobal) cri.uniqueResult();
	}

}
