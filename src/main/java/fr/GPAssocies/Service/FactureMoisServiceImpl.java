package fr.GPAssocies.Service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.FactureMoisDao;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

@Service("factureMoisService")
public class FactureMoisServiceImpl implements FactureMoisService {
	@Autowired
	@Qualifier("factureMoisDao")
	private FactureMoisDao factureMoisDao;

	@Transactional
	public void create(FactureMois factureMois) {
		factureMoisDao.create(factureMois);
	}

	@Transactional
	public void update(FactureMois factureMois) {
		factureMoisDao.update(factureMois);
	}

	@Transactional
	public void delete(FactureMois factureMois) {
		factureMoisDao.delete(factureMois);
	}

	@Transactional
	public List<FactureMois> findAll() {
		return factureMoisDao.findAll();
	}

	@Transactional
	public FactureMois findParMC(String MC) {
		return factureMoisDao.findParMC(MC);
	}

	public double calculmontantTtc(double montantHt, double tauxTva) {
		return factureMoisDao.calculmontantTtc(montantHt, tauxTva);
	}

	public LocalDate strToDate(String dateStr) {
		return factureMoisDao.strToDate(dateStr);
	}

	public String dateToStr(LocalDate date) {
		return factureMoisDao.dateToStr(date);
	}

	@Transactional
	public boolean statutFactMois(FactureMois factureMois) {
		return factureMoisDao.statutFactMois(factureMois);
	}

	public List<FactureMois> findByFactG(FactureGlobal factureGlobal) {
		return factureMoisDao.findByFactG(factureGlobal);
	}


}
