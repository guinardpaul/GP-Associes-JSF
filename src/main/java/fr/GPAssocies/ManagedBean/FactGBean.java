package fr.GPAssocies.ManagedBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.joda.time.LocalDate;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.GPAssocies.Service.ClientService;
import fr.GPAssocies.Service.DevisService;
import fr.GPAssocies.Service.FactureGService;
import fr.GPAssocies.Service.FactureMoisService;
import fr.GPAssocies.Service.ReglementService;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;
import fr.GPAssocies.entities.FactureMois;
import fr.GPAssocies.entities.Reglement;

@Component
@ManagedBean
@ViewScoped
public class FactGBean {
	@Autowired
	private ClientService clientService;
	@Autowired
	private ReglementService reglementService;
	@Autowired
	private DevisService devisService;
	@Autowired
	private FactureGService factureGService;
	@Autowired
	private FactureMoisService factureMoisService;
	@Autowired
	private ClientBean clientBean;
	@Autowired
	private DevisBean devisBean;
	@Autowired
	private FactMBean factMBean;

	private FactureMois factureMois = new FactureMois();
	private Date date;
	private FactureGlobal factureGlobal = new FactureGlobal();
	private List<Devis> listDevis = new ArrayList<Devis>();
	private List<FactureGlobal> listFactureG = new ArrayList<FactureGlobal>();
	private double somme;

	public ReglementService getReglementService() {
		return reglementService;
	}

	public void setReglementService(ReglementService reglementService) {
		this.reglementService = reglementService;
	}

	public FactMBean getFactMBean() {
		return factMBean;
	}

	public void setFactMBean(FactMBean factMBean) {
		this.factMBean = factMBean;
	}

	public double getSomme() {
		return somme;
	}

	public void setSomme(double somme) {
		this.somme = somme;
	}

	public DevisBean getDevisBean() {
		return devisBean;
	}

	public void setDevisBean(DevisBean devisBean) {
		this.devisBean = devisBean;
	}

	public FactureMoisService getFactureMoisService() {
		return factureMoisService;
	}

	public void setFactureMoisService(FactureMoisService factureMoisService) {
		this.factureMoisService = factureMoisService;
	}

	public FactureMois getFactureMois() {
		return factureMois;
	}

	public void setFactureMois(FactureMois factureMois) {
		this.factureMois = factureMois;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public DevisService getDevisService() {
		return devisService;
	}

	public void setDevisService(DevisService devisService) {
		this.devisService = devisService;
	}

	public FactureGService getFactureGService() {
		return factureGService;
	}

	public void setFactureGService(FactureGService factureGService) {
		this.factureGService = factureGService;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}

	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}

	public List<Devis> getListDevis() {
		return listDevis;
	}

	public void setListDevis(List<Devis> listDevis) {
		this.listDevis = listDevis;
	}

	public List<FactureGlobal> getListFactureG() {
		return listFactureG;
	}

	public void setListFactureG(List<FactureGlobal> listFactureG) {
		this.listFactureG = listFactureG;
	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	// Méthodes
	public void validerDevis(Devis d) {
		factureGlobal.setDateCreation(d.getDateCreation());
		factureGlobal.setRef(d.getRef());
		factureGlobal.setMontantHT(d.getMontantHT());
		factureGlobal.setMontantTTC(d.getMontantTTC());
		factureGlobal.setTauxTva(d.getTauxTva());
		factureGlobal.setClient(d.getClient());
		factureGlobal.setDevis(d);

		date = d.getDateCreation().toDate();
		clientBean.consulterClient(clientBean.getClient());
	}

	public void createFacture() {
		factureGlobal.setDateCreation(new LocalDate(date));
		factureGlobal.setStatutFactG(true);
		factureGlobal.setMontantTTC(factureGlobal.getMontantHT() + factureGlobal.getTauxTva());
		factureGService.create(factureGlobal);

		clientBean.getClient().setStatutClient(clientService.statut(clientBean.getClient()));
		clientService.update(clientBean.getClient());

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Facture créée.", null));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Statut client mis à jour.", null));
		
		clientBean.consulterClient(clientBean.getClient());
		clientBean.sommeFactG();
	}

	public void deleteFactG(FactureGlobal fg) {
		if (factureGService.findByFactG(fg).isEmpty()) {
			factureGService.delete(fg);
			
			// set Statut client
			clientBean.getClient().setStatutClient(clientService.statut(clientBean.getClient()));
			clientService.update(clientBean.getClient());
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Facture Supprimé.", null));
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Statut client mis à jour.", null));
			
			clientBean.consulterClient(clientBean.getClient());
			clientBean.sommeFactG();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Suppression impossible. Facture liée à une ou plusieurs facture Mois. Ref: " + 
					factureGService.findByFactG(fg).get(0).getRefFactMois() + ", ...", null));
		}
	}

	public void valueFactG(FactureGlobal fg) {
		date = fg.getDateCreation().toDate();
		factureGlobal = fg;
	}

	public String consulterFactG(FactureGlobal fg) {
		factureGlobal = fg;
		factMBean.getAllFactM();
		somme = 0;
		if (!factureGService.findByFactG(fg).isEmpty()) {
			for (FactureMois f : factureGService.findByFactG(fg)) {
				if (!reglementService.findReglementByFactureMois(f).isEmpty()) {
					for (Reglement r : reglementService.findReglementByFactureMois(f)) {
						somme += r.getReglementTtc();
					}
				}
			}
		}
		return "consulterFacture?faces-redirect=true";
	}
	
	// format String to java.util.Date pour affichage xhtml
	public String onDateSelect(SelectEvent event) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.format(event.getObject());
	}

}
