package fr.GPAssocies.ManagedBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.joda.time.LocalDate;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.GPAssocies.Service.ClientService;
import fr.GPAssocies.Service.FactureGService;
import fr.GPAssocies.Service.FactureMoisService;
import fr.GPAssocies.Service.ReglementService;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

@Component
@ManagedBean
@ViewScoped
public class FactMBean {
	@Autowired
	private ClientService clientService;
	@Autowired
	private ReglementService reglementService;
	@Autowired
	private FactureGService factureGService;
	@Autowired
	private FactureMoisService factureMoisService;
	@Autowired
	private ClientBean clientBean;
	@Autowired
	private DevisBean devisBean;
	@Autowired
	private FactGBean factGBean;
	private FactureMois factureMois = new FactureMois();
	private Reglement reglement = new Reglement();
	private Date date;
	private List<FactureMois> listFactM = new ArrayList<FactureMois>();
	private boolean reglementComplet;
	private double reglementClient;

	// Getters/Setters
	public boolean isReglementComplet() {
		return reglementComplet;
	}

	public Reglement getReglement() {
		return reglement;
	}

	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}

	public double getReglementClient() {
		return reglementClient;
	}

	public void setReglementClient(double reglementClient) {
		this.reglementClient = reglementClient;
	}

	public void setReglementService(ReglementService reglementService) {
		this.reglementService = reglementService;
	}

	public void setReglementComplet(boolean reglementComplet) {
		this.reglementComplet = reglementComplet;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void setFactureGService(FactureGService factureGService) {
		this.factureGService = factureGService;
	}

	public void setFactureMoisService(FactureMoisService factureMoisService) {
		this.factureMoisService = factureMoisService;
	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	public DevisBean getDevisBean() {
		return devisBean;
	}

	public void setDevisBean(DevisBean devisBean) {
		this.devisBean = devisBean;
	}

	public FactGBean getFactGBean() {
		return factGBean;
	}

	public void setFactGBean(FactGBean factGBean) {
		this.factGBean = factGBean;
	}

	public FactureMois getFactureMois() {
		return factureMois;
	}

	public void setFactureMois(FactureMois factureMois) {
		this.factureMois = factureMois;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<FactureMois> getListFactM() {
		return listFactM;
	}

	public void setListFactM(List<FactureMois> listFactM) {
		this.listFactM = listFactM;
	}

	// Methodes
	public FactMBean() {
	}

	@PostConstruct
	public void init() {
		listFactM = new ArrayList<FactureMois>();
	}

	public List<FactureMois> getAllFactM() {
		listFactM = factureGService.findByFactG(factGBean.getFactureGlobal());
		return listFactM;
	}

	public void createFactM() {
		if (reglementClient != 0) {
			reglement.setDateReglement(new LocalDate(date));
			reglement.setReglementTtc(reglementClient);
		}
		factureMois.setDateCreation(new LocalDate(date));
		factureMois.setFactureGlobal(factGBean.getFactureGlobal());
		factureMois.setStatutFactMois(factureMoisService.statutFactMois(factureMois));
		factureMoisService.create(factureMois);

		factGBean.getFactureGlobal().setStatutFactG(factureGService.statutFactGlobal(factGBean.getFactureGlobal()));
		factureGService.update(factGBean.getFactureGlobal());

		clientBean.getClient().setStatutClient(clientService.statut(clientBean.getClient()));
		clientService.update(clientBean.getClient());

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Facture créée.", null));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Statut facture mis à jour.", null));

		factureMois = new FactureMois();
		date = new Date();
		factGBean.consulterFactG(factGBean.getFactureGlobal());
	}

	public void addReglement() {
		factureMois.setDateCreation(new LocalDate(date));
		factureMois.setFactureGlobal(factGBean.getFactureGlobal());
		factureMois.setStatutFactMois(factureMoisService.statutFactMois(factureMois));
		factureMoisService.update(factureMois);

		factGBean.getFactureGlobal().setStatutFactG(factureGService.statutFactGlobal(factGBean.getFactureGlobal()));
		factureGService.update(factGBean.getFactureGlobal());

		clientBean.getClient().setStatutClient(clientService.statut(clientBean.getClient()));
		clientService.update(clientBean.getClient());

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Réglement Ajouté.", null));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Statut facture mis à jour.", null));

		factureMois = new FactureMois();
		date = new Date();
		reglementComplet = false;
		factGBean.consulterFactG(factGBean.getFactureGlobal());
	}

	public void deleteFactM(FactureMois fm) {
		factureMoisService.delete(fm);
		if (!factureGService.findByFactG(factGBean.getFactureGlobal()).isEmpty()) {
			factGBean.getFactureGlobal().setStatutFactG(factureGService.statutFactGlobal(factGBean.getFactureGlobal()));
			factureGService.update(factGBean.getFactureGlobal());

			clientBean.getClient().setStatutClient(clientService.statut(clientBean.getClient()));
			clientService.update(clientBean.getClient());
		} else {
			factGBean.getFactureGlobal().setStatutFactG(false);
			factureGService.update(factGBean.getFactureGlobal());

			clientBean.getClient().setStatutClient(false);
			clientService.update(clientBean.getClient());
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Facture Supprimé.", null));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Statut facture mis à jour.", null));

		factGBean.consulterFactG(factGBean.getFactureGlobal());
	}

	public void valueFactG() {
		factureMois.setRefFactMois(factGBean.getFactureGlobal().getRef());
		factureMois.setMontantFacture(factGBean.getFactureGlobal().getMontantTTC());
		factureMois.setFactureGlobal(factGBean.getFactureGlobal());
		date = new Date();
	}

	public void valueFactM(FactureMois fm) {
		date = fm.getDateCreation().toDate();
		factureMois = fm;
	}

	public double getReglementClient(FactureMois fm) {
		double somme = 0;
		if (!reglementService.findReglementByFactureMois(fm).isEmpty()) {
			for (Reglement r : reglementService.findReglementByFactureMois(fm)) {
				somme += r.getReglementTtc();
			}
		}
		return somme;
	}

	/*
	 * public void reglement(){ if (reglementComplet == true){
	 * factureMois.setReglement(factureMois.getMontantFacture()); } else {
	 * factureMois.setReglement(0); } }
	 */

	// format String to java.util.Date pour affichage xhtml
	public String onDateSelect(SelectEvent event) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.format(event.getObject());
	}

	public String onDateInput(LocalDate date) {
		return factureMoisService.dateToStr(date);
	}

}
