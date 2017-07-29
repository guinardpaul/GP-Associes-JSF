package fr.GPAssocies.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.GPAssocies.Util.DaoImpl;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("clientDao")
public class ClientDaoImpl extends DaoImpl<Client> implements ClientDao {
	private final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Client> findAll() {
		logger.info("App start");
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Client.class);
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findAll:" + cri.list());
		return cri.list();
	}

	public Client findParMC(String MC) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Client.class);
			cri.add(Restrictions.ilike("nom", "%" + MC + "%"));
		} catch (HibernateException he) {
			logger.error("Error" + he);
		}
		logger.info("findParMC:" + cri.uniqueResult());
		return (Client) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Devis> findDevisByClient(Client client) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(Devis.class);
			cri.add(Restrictions.eq("client", client));
		} catch (HibernateException he) {
			logger.error("Error:" + he);
		}
		logger.info("findDevisByClient:" + cri.list());
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	public List<FactureGlobal> findFactGByClient(Client client) {
		Criteria cri = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cri = session.createCriteria(FactureGlobal.class);
			cri.add(Restrictions.eq("client", client));
		} catch (HibernateException he) {
			logger.error("Error " + he);
		}
		logger.info("findFactGByClient:" + cri.list());
		return cri.list();
	}

	public boolean statut(Client client) {
		List<FactureGlobal> factureGlobals = new ArrayList<FactureGlobal>();
		boolean statGlobal = true;
		try {
			if (!findFactGByClient(client).isEmpty()) {
			factureGlobals = findFactGByClient(client);
				for (FactureGlobal f : factureGlobals) {
					if (f.isStatutFactG() == false) {
						statGlobal = false;
					}
				}
			} else {
				statGlobal = false;
			}
		} catch (Exception e) {
			logger.error("Error:" + e);
		}
		if (statGlobal == true) {
			return true;
		} else {
			return false;
		}
	}

}
