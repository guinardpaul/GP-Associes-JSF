package fr.GPAssocies.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.GPAssocies.Service.ClientService;
import fr.GPAssocies.Service.DevisService;
import fr.GPAssocies.Service.FactureGService;
import fr.GPAssocies.Service.FactureMoisService;
import fr.GPAssocies.entities.Client;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;

@Component
@ManagedBean
@ApplicationScoped
public class ClientBean {
	@Autowired
	private ClientService clientService;
	@Autowired
	private DevisService devisService;
	@Autowired
	private FactureGService factureGService;
	@Autowired
	private FactureMoisService factureMoisService;
	private Client client;
	private Client client2 = new Client();
	private Client client3 = new Client();
	private FactureGlobal factureGlobal;
	private List<Client> clients;
	private List<Devis> listDevis;
	private List<FactureGlobal> listFactG;
	private List<FactureMois> listFactM;

	// Getters-Setters
	public Client getClient2() {
		return client2;
	}
	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}
	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}
	public FactureMoisService getFactureMoisService() {
		return factureMoisService;
	}
	public void setFactureMoisService(FactureMoisService factureMoisService) {
		this.factureMoisService = factureMoisService;
	}
	public List<FactureMois> getListFactM() {
		return listFactM;
	}
	public void setListFactM(List<FactureMois> listFactM) {
		this.listFactM = listFactM;
	}
	public FactureGService getFactureGService() {
		return factureGService;
	}
	public void setFactureGService(FactureGService factureGService) {
		this.factureGService = factureGService;
	}
	public List<FactureGlobal> getListFactG() {
		return listFactG;
	}
	public void setListFactG(List<FactureGlobal> listFactG) {
		this.listFactG = listFactG;
	}
	public DevisService getDevisService() {
		return devisService;
	}
	public void setDevisService(DevisService devisService) {
		this.devisService = devisService;
	}
	public Client getClient3() {
		return client3;
	}
	public void setClient3(Client client3) {
		this.client3 = client3;
	}
	public List<Devis> getListDevis() {
		return listDevis;
	}
	public void setListDevis(List<Devis> listDevis) {
		this.listDevis = listDevis;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public void setClient2(Client client2) {
		this.client2 = client2;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	// Methodes
	// Constructeur vide nécessaire pour fonction init()
	public ClientBean() {
	}
	
	// Fonction init() appelée à la création du ManagedBean
	@PostConstruct
	public void init() {
		clients = clientService.findAll();
		listDevis = new ArrayList<Devis>();
		listFactG = new ArrayList<FactureGlobal>();
		listFactM = new ArrayList<FactureMois>();
	}

	// Cherche tous les clients dans la DB
	public List<Client> getAllClient() {
		clients = clientService.findAll();
		return clients;
	}

	// Création client. utilisation client3 pour pour séparer data avec fonction update
	public void createClient() {
		// Récup valeur client3 dans form
		clientService.create(client3);
		// Display msg success
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Client Créé", null));
		// Refresh list clients
		getAllClient();
		// Reset value client3
		client3 = new Client();
	}

	// Update client. utilisation client2 pour pour séparer data avec fonction create
	public void updateClient() {
		clientService.update(client2);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Client Modifié", null));
		getAllClient();
		client2 = new Client();
	}
	
	// Delete client. utilisation client3 pour pour séparer data avec fonction update
	public void deleteClient(Client c) {
		// Check si client contient des devis
		if (devisService.findByClient(c).isEmpty()) {
			clientService.delete(c);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Client Supprimé.", null));
			getAllClient();
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Suppression impossible. Client lié à un ou plusieurs Devis. Ref: "
									+ devisService.findByClient(c).get(0).getRef() + ", ...",
							null));
		}
	}

	// Charge client lors de la consultation des Devis/Factures pour un client
	// utilise client pour séparé value avec fonctions create et update
	public String consulterClient(Client c) {
		client = c;
		// Find devis par client
		listDevis = devisService.findByClient(client);
		// Find facture global par client
		listFactG = factureGService.findByClient(client);
		// Appel fonction somme facture global (display in footer table facture)
		sommeFactG();
		// Redirection effective pour changer active nav bar
		return "consulterClient.xhtml?faces-redirect=true&i=1&jftfdi=&jffi=consulterClient";
	}

	// Calcul somme facture global
	public double sommeFactG() {
		double somme = 0;
		if (!listFactG.isEmpty()) {
			for (FactureGlobal fg : listFactG) {
				somme += fg.getMontantTTC();
			}
		}
		return somme;
	}

}
