package fr.GPAssocies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetailsDevis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetailDev;
	private double montantHT;
	private double tauxTVA;
	private double montantTTC;
	@ManyToOne
	private Devis devis;

	public DetailsDevis() {
		super();
	}

	public DetailsDevis(double montantHT, double tauxTVA, double montantTTC) {
		super();;
		this.montantHT = montantHT;
		this.tauxTVA = tauxTVA;
		this.montantTTC = montantTTC;
	}

	public int getIdDetailDev() {
		return idDetailDev;
	}

	public void setIdDetailDev(int idDetailDev) {
		this.idDetailDev = idDetailDev;
	}

	public double getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(double montantHT) {
		this.montantHT = montantHT;
	}

	public double getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(double tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	public double getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailsDevis [idDetailDev=");
		builder.append(idDetailDev);
		builder.append(", montantHT=");
		builder.append(montantHT);
		builder.append(", tauxTVA=");
		builder.append(tauxTVA);
		builder.append(", montantTTC=");
		builder.append(montantTTC);
		builder.append(", devis=");
		builder.append(devis);
		builder.append("]");
		return builder.toString();
	}

}
