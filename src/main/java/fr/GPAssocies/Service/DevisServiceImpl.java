package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.BugDaoImpl;
import fr.GPAssocies.Dao.DevisDao;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;

@Service("devisService")
public class DevisServiceImpl implements DevisService {
	private final Logger logger = LoggerFactory.getLogger(BugDaoImpl.class);
 
	@Autowired
	private DevisDao devisDao;
	public void setDevisDao(DevisDao devisDao) {
		this.devisDao = devisDao;
	}

	@Transactional
	public void create(Devis devis) {
		try{
		devisDao.create(devis);
	}catch(RuntimeException e){
		logger.error("Error :"+e);
	}
	}

	@Transactional
	public void update(Devis devis) {
		devisDao.update(devis);
	}

	@Transactional
	public void delete(Devis devis) {
		devisDao.delete(devis);
	}

	@Transactional
	public List<Devis> findAll() {
		return devisDao.findAll();
	}

	@Transactional
	public Devis findParMC(String MC) {
		return devisDao.findParMC(MC);
	}

	public LocalDate strToDate(String dateStr) {
		return devisDao.strToDate(dateStr);
	}

	public String dateToStr(LocalDate date) {
		return devisDao.dateToStr(date);
	}

	public double calculmontantTtc(double montantHt, double tauxTva) {
		return devisDao.calculmontantTtc(montantHt, tauxTva);
	}
	
	@Transactional
	public List<Devis> findByClient(Client client) {
		return devisDao.findByClient(client);
	}
	@Transactional
	public Devis findById(int id) {
		return devisDao.findById(id);
	}

}
