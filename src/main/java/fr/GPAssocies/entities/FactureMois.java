package fr.GPAssocies.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

@Entity
@Table(name = "factureMois")
public class FactureMois {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factMois")
	private int id_factMois;

	@Column(name = "refFactMois")
	@Size(min=1, message="ref vide!")
	private String refFactMois;

	@Column(name = "statutFactMois")
	private boolean statutFactMois;

	@Column(name = "dateCreation")
	private LocalDate dateCreation;

	@Column(name = "MontantFacture")
	private double montantFacture;
	
	@ManyToOne
	private FactureGlobal factureGlobal;
	
	@OneToMany(mappedBy="factureMois", orphanRemoval=true)
	private List<Reglement> reglement;

	public List<Reglement> getReglement() {
		return reglement;
	}

	public void setReglement(List<Reglement> reglement) {
		this.reglement = reglement;
	}

	public int getId_factMois() { 
		return id_factMois;
	}

	public void setId_factMois(int id_factMois) {
		this.id_factMois = id_factMois;
	}

	public String getRefFactMois() {
		return refFactMois;
	}

	public void setRefFactMois(String refFactMois) {
		this.refFactMois = refFactMois;
	}

	public boolean isStatutFactMois() {
		return statutFactMois;
	}

	public void setStatutFactMois(boolean statutFactMois) {
		this.statutFactMois = statutFactMois;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}

	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}

	public FactureMois() {
		super();
	}

	public FactureMois(String refFactMois, boolean statutFactMois, LocalDate dateCreation, double montantFacture,
			FactureGlobal factureGlobal, List<Reglement> reglement) {
		super();
		this.refFactMois = refFactMois;
		this.statutFactMois = statutFactMois;
		this.dateCreation = dateCreation;
		this.montantFacture = montantFacture;
		this.factureGlobal = factureGlobal;
		this.reglement = reglement;
	}

	public FactureMois(String refFactMois, boolean statutFactMois, LocalDate dateCreation, double montantFacture) {
		super();
		this.refFactMois = refFactMois;
		this.statutFactMois = statutFactMois;
		this.dateCreation = dateCreation;
		this.montantFacture = montantFacture;
	}

	@Override
	public String toString() {
		return "FactureMois [id_factMois=" + id_factMois + ", refFactMois=" + refFactMois + ", statutFactMois="
				+ statutFactMois + ", dateCreation=" + dateCreation + ", montantFacture=" + montantFacture
				+ ", reglement=" + reglement + ", factureGlobal=" + factureGlobal + "]";
	}
	

}
