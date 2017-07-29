package fr.GPAssocies.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.DetailsDevisDao;
import fr.GPAssocies.entities.DetailsDevis;
import fr.GPAssocies.entities.Devis;

@Service("detailsDevisService")
public class DetailsDevisServiceImpl implements DetailsDevisService {
	
	@Autowired
	private DetailsDevisDao detailsDevisDao;

	public void setDetailsDevisDao(DetailsDevisDao detailsDevisDao) {
		this.detailsDevisDao = detailsDevisDao;
	}

	@Transactional
	public List<DetailsDevis> findByDevis(Devis devis) {
		return detailsDevisDao.findByDevis(devis);
	}
	
	@Transactional
	public void create(DetailsDevis detailsDevis) {
		detailsDevisDao.create(detailsDevis);
	}

	@Transactional
	public void update(DetailsDevis detailsDevis) {
		detailsDevisDao.update(detailsDevis);
	}

	@Transactional
	public void delete(DetailsDevis detailsDevis) {
		detailsDevisDao.delete(detailsDevis);
	}

}
