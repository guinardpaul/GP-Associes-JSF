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
import fr.GPAssocies.Service.DetailsDevisService;
import fr.GPAssocies.Service.DevisService;
import fr.GPAssocies.Service.FactureGService;
import fr.GPAssocies.entities.DetailsDevis;
import fr.GPAssocies.entities.Devis;
import fr.GPAssocies.entities.FactureGlobal;

@Component
@ManagedBean
@ViewScoped
public class DevisBean {
	@Autowired
	private ClientService clientService;
	@Autowired
	private DevisService devisService;
	@Autowired
	private FactureGService factureGService;
	@Autowired
	private ClientBean clientBean;
	@Autowired
	private DetailsDevisService detailsDevisService;
	private List<Devis> listDevis = new ArrayList<Devis>();
	private List<FactureGlobal> listFactG = new ArrayList<FactureGlobal>();
	private List<DetailsDevis> listDetailDevis = new ArrayList<DetailsDevis>();
	private Devis devis = new Devis();
	private Devis devis2 = new Devis();
	private Date date;
	private FactureGlobal factureGlobal = new FactureGlobal();
	private DetailsDevis detailsDevis1 = new DetailsDevis();
	private DetailsDevis detailsDevis2 = new DetailsDevis();
	private DetailsDevis detailsDevis3 = new DetailsDevis();

	// Getters-Setters
	public ClientService getClientService() {
		return clientService;
	}

	public List<DetailsDevis> getListDetailDevis() {
		return listDetailDevis;
	}

	public void setListDetailDevis(List<DetailsDevis> listDetailDevis) {
		this.listDetailDevis = listDetailDevis;
	}

	public DetailsDevis getDetailsDevis1() {
		return detailsDevis1;
	}

	public void setDetailsDevis1(DetailsDevis detailsDevis1) {
		this.detailsDevis1 = detailsDevis1;
	}

	public DetailsDevis getDetailsDevis2() {
		return detailsDevis2;
	}

	public void setDetailsDevis2(DetailsDevis detailsDevis2) {
		this.detailsDevis2 = detailsDevis2;
	}

	public DetailsDevis getDetailsDevis3() {
		return detailsDevis3;
	}

	public void setDetailsDevis3(DetailsDevis detailsDevis3) {
		this.detailsDevis3 = detailsDevis3;
	}

	public DetailsDevisService getDetailsDevisService() {
		return detailsDevisService;
	}

	public void setDetailsDevisService(DetailsDevisService detailsDevisService) {
		this.detailsDevisService = detailsDevisService;
	}

	public List<FactureGlobal> getListFactG() {
		return listFactG;
	}

	public void setListFactG(List<FactureGlobal> listFactG) {
		this.listFactG = listFactG;
	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public List<Devis> getListDevis() {
		return listDevis;
	}

	public void setListDevis(List<Devis> listDevis) {
		this.listDevis = listDevis;
	}

	public Devis getDevis2() {
		return devis2;
	}

	public void setDevis2(Devis devis2) {
		this.devis2 = devis2;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public FactureGService getFactureGService() {
		return factureGService;
	}

	public void setFactureGService(FactureGService factureGService) {
		this.factureGService = factureGService;
	}

	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}

	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DevisService getDevisService() {
		return devisService;
	}

	public void setDevisService(DevisService devisService) {
		this.devisService = devisService;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	// Methodes
	public List<Devis> getAllDevis() {
		listDevis = devisService.findByClient(clientBean.getClient());
		return listDevis;
	}
	
	public void listenerDevis(){
		detailsDevis1.setTauxTVA(5.5);
		detailsDevis2.setTauxTVA(10);
		detailsDevis3.setTauxTVA(20);
		
		detailsDevis1.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis1.getMontantHT(), detailsDevis1.getTauxTVA()));
		detailsDevis2.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis2.getMontantHT(), detailsDevis2.getTauxTVA()));
		detailsDevis3.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis3.getMontantHT(), detailsDevis3.getTauxTVA()));
	}
	
	public void calculDevis(){
		detailsDevis1.setTauxTVA(5.5);
		detailsDevis2.setTauxTVA(10);
		detailsDevis3.setTauxTVA(20);
		
		detailsDevis1.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis1.getMontantHT(), detailsDevis1.getTauxTVA()));
		detailsDevis2.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis2.getMontantHT(), detailsDevis2.getTauxTVA()));
		detailsDevis3.setMontantTTC(devisService.calculmontantTtc
				(detailsDevis3.getMontantHT(), detailsDevis3.getTauxTVA()));
		
		double montantHT = detailsDevis1.getMontantHT() + detailsDevis2.getMontantHT() + detailsDevis3.getMontantHT();
		double tauxTVA = detailsDevis1.getMontantHT()*0.055 + detailsDevis2.getMontantHT()*0.1 + 
				detailsDevis3.getMontantHT()*0.2;
		double montantTTC = detailsDevis1.getMontantHT()*1.055 + detailsDevis2.getMontantHT()*1.1 + 
				detailsDevis3.getMontantHT()*1.2;
		
		devis2.setMontantHT(montantHT);
		devis2.setTauxTva(tauxTVA);
		devis2.setMontantTTC(montantTTC);
		devis.setMontantHT(montantHT);
		devis.setTauxTva(tauxTVA);
		devis.setMontantTTC(montantTTC);
	}

	public void createDevis() {
		devis2.setDateCreation(new LocalDate(date));
		devis2.setClient(clientBean.getClient());
		calculDevis();
		devisService.create(devis2);
		
		detailsDevis1.setDevis(devis2);
		detailsDevis2.setDevis(devis2);
		detailsDevis3.setDevis(devis2);
		detailsDevisService.create(detailsDevis1);
		detailsDevisService.create(detailsDevis2);
		detailsDevisService.create(detailsDevis3);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Devis Créé", null));
		
		// Reset values
		devis2 = new Devis();
		detailsDevis1 = new DetailsDevis();
		detailsDevis2 = new DetailsDevis();
		detailsDevis3 = new DetailsDevis();
		clientBean.consulterClient(clientBean.getClient());
	}

	public void clear(){
		devis2 = new Devis();
	}
	
	public void updateDevis() {
		devis.setDateCreation(new LocalDate(date));
		devis.setClient(clientBean.getClient());
		calculDevis();
		devisService.update(devis);

		detailsDevisService.update(detailsDevis1);
		detailsDevisService.update(detailsDevis2);
		detailsDevisService.update(detailsDevis3);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Devis Modifié", null));

		devis = new Devis();
		detailsDevis1 = new DetailsDevis();
		detailsDevis2 = new DetailsDevis();
		detailsDevis3 = new DetailsDevis();
		clientBean.consulterClient(clientBean.getClient());
	}

	public void deleteDevis(Devis d) {
		if (factureGService.findByDevis(d) == null) {
			devisService.delete(d);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Devis Supprimé.", null));
			clientBean.consulterClient(clientBean.getClient());
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Suppression impossible. Devis lié à une facture. Ref: " + factureGService.findByDevis(d).getRef(), null));
		}
	}

	public void listDetails(Devis d){
		listDetailDevis = detailsDevisService.findByDevis(d);
		System.out.println(detailsDevisService.findByDevis(d));
	}
	
	public void valueDevis(Devis d) {
		date = d.getDateCreation().toDate();
		devis = d;
		listDetailDevis = detailsDevisService.findByDevis(devis);
		detailsDevis1 = listDetailDevis.get(0);
		detailsDevis2 = listDetailDevis.get(1);
		detailsDevis3 = listDetailDevis.get(2);	
	}

	// format String to java.util.Date pour affichage xhtml
	public String onDateSelect(SelectEvent event) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.format(event.getObject());
	}

	public String onDateInput(LocalDate date) {
		return devisService.dateToStr(date);
	}

}
