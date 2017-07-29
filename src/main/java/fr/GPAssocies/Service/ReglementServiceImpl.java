package fr.GPAssocies.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.GPAssocies.Dao.ReglementDao;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

@Service("ReglementService")
public class ReglementServiceImpl implements ReglementService {

	@Autowired
	private ReglementDao reglementDao;

	public void setReglementDao(ReglementDao reglementDao) {
		this.reglementDao = reglementDao;
	}

	public void create(Reglement reglement) {
		reglementDao.create(reglement);
	}

	public void update(Reglement reglement) {
		reglementDao.update(reglement);
	}

	public void delete(Reglement reglement) {
		reglementDao.delete(reglement);
	}

	public Reglement findbyId(int id) {
		return reglementDao.findbyId(id);
	}

	public List<Reglement> findReglementByFactureMois(FactureMois factureMois) {
		return reglementDao.findReglementByFactureMois(factureMois);
	}

}
