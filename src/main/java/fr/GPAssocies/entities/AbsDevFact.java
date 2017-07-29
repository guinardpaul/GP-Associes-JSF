package fr.GPAssocies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 1 Table/class fille
public abstract class AbsDevFact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_devFact")
	private int id_devFact;
	
	@Column(name = "ref")
	@Size(min=1, message="ref vide!")
	protected String ref;
	
	@Column(name = "dateCreation")
	protected LocalDate dateCreation;

	@Column(name = "montantHT")
	protected double montantHT;

	@Column(name = "tauxTva")
	protected double tauxTva;

	@Column(name = "montantTTC")
	protected double montantTTC;

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(double montantHT) {
		this.montantHT = montantHT;
	}

	public double getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(double tauxTva) {
		this.tauxTva = tauxTva;
	}

	public double getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
	}

	public int getId_devFact() {
		return id_devFact;
	}

	public AbsDevFact(String ref, LocalDate dateCreation, double montantHT, double tauxTva, double montantTTC) {
		super();
		this.ref = ref;
		this.dateCreation = dateCreation;
		this.montantHT = montantHT;
		this.tauxTva = tauxTva;
		this.montantTTC = montantTTC;
	}

	public AbsDevFact(String ref, LocalDate dateCreation, double montantHT, double tauxTva) {
		super();
		this.ref = ref;
		this.dateCreation = dateCreation;
		this.montantHT = montantHT;
		this.tauxTva = tauxTva;
	}

	public AbsDevFact() {
		// TODO Auto-generated constructor stub
	}

	 public void setId_devFact(int id_devFact) {
	 this.id_devFact = id_devFact;
	 }

}
