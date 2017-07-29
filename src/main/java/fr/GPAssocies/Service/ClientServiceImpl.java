package fr.GPAssocies.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.GPAssocies.Dao.ClientDao;
import fr.GPAssocies.entities.Client;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Transactional
	public void create(Client client) {
		clientDao.create(client);
	}

	@Transactional
	public void update(Client client) {
		clientDao.update(client);
	}

	@Transactional
	public void delete(Client client) {
		clientDao.delete(client);
	}

	@Transactional
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Transactional
	public Client findParMC(String MC) {
		return clientDao.findParMC(MC);
	}

	@Transactional
	public boolean statut(Client client) {
		return clientDao.statut(client);
	}

}
