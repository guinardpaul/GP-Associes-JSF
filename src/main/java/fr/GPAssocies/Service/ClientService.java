package fr.GPAssocies.Service;

import java.util.List;

import fr.GPAssocies.entities.Client;

public interface ClientService {
	/**
	 * create client
	 * 
	 * @param client
	 */
	void create(Client client);

	/**
	 * update client
	 * 
	 * @param client
	 */
	void update(Client client);

	/**
	 * delete client
	 * 
	 * @param client
	 */
	void delete(Client client);

	/**
	 * @param Client
	 * @return List
	 */
	List<Client> findAll();

	/**
	 * @param MC
	 * @return Client
	 */
	Client findParMC(String MC);

	/**
	 * @param statut
	 */
	boolean statut(Client client);
}
