package fr.GPAssocies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.joda.time.LocalDate;

@Entity
public class Reglement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReglement;
	private LocalDate dateReglement;
	private double reglementTtc;
	@ManyToOne
	private FactureMois factureMois;

	public int getIdReglement() {
		return idReglement;
	}

	public void setIdReglement(int idReglement) {
		this.idReglement = idReglement;
	}

	public LocalDate getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(LocalDate dateReglement) {
		this.dateReglement = dateReglement;
	}

	public double getReglementTtc() {
		return reglementTtc;
	}

	public void setReglementTtc(double reglementTtc) {
		this.reglementTtc = reglementTtc;
	}

	public FactureMois getFactureMois() {
		return factureMois;
	}

	public void setFactureMois(FactureMois factureMois) {
		this.factureMois = factureMois;
	}

	public Reglement() {
		super();
	}

	public Reglement(LocalDate dateReglement, double reglementTtc, FactureMois factureMois) {
		super();
		this.dateReglement = dateReglement;
		this.reglementTtc = reglementTtc;
		this.factureMois = factureMois;
	}

	public Reglement(LocalDate dateReglement, double reglementTtc) {
		super();
		this.dateReglement = dateReglement;
		this.reglementTtc = reglementTtc;
	}

}
