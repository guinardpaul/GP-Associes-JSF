package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.FactureGDao;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

@Service("factureGService")
public class FactureGServiceImpl implements FactureGService {
	@Autowired
	@Qualifier("factureGDao")
	private FactureGDao factureGDao;

	@Transactional
	public void create(FactureGlobal factG) {
		factureGDao.create(factG);
	}

	@Transactional
	public void update(FactureGlobal factG) {
		factureGDao.update(factG);
	}

	@Transactional
	public void delete(FactureGlobal factG) {
		factureGDao.delete(factG);
	}

	@Transactional
	public List<FactureGlobal> findAll() {
		return factureGDao.findAll();
	}

	@Transactional
	public FactureGlobal findParMC(String MC) {
		return factureGDao.findParMC(MC);
	}

	public double calculmontantTtc(double montantHt, double tauxTva) {
		return factureGDao.calculmontantTtc(montantHt, tauxTva);
	}

	public LocalDate strToDate(String dateStr) {
		return factureGDao.strToDate(dateStr);
	}

	public String dateToStr(LocalDate date) {
		return factureGDao.dateToStr(date);
	}

	@Transactional
	public boolean statutFactGlobal(FactureGlobal factureGlobal) {
		return factureGDao.statutFactGlobal(factureGlobal);
	}

	@Transactional
	public List<FactureGlobal> findByClient(Client client) {
		return factureGDao.findByClient(client);
	}
	
	@Transactional
	public List<FactureMois> findByFactG(FactureGlobal factureGlobal) {
		return factureGDao.findFactMByFactG(factureGlobal);
	}

	@Transactional
	public FactureGlobal findByDevis(Devis devis) {
		return factureGDao.findByDevis(devis);
	}

}
