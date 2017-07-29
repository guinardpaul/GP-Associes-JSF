package fr.GPAssocies.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDate;

@Entity
@Table(name = "devis")
public class Devis extends AbsDevFact {
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy="devis", orphanRemoval=true)
	private List<DetailsDevis> detailsDevis;

	public Devis(String ref, LocalDate dateCreation, double montantHT, double tauxTva) {
		super(ref, dateCreation, montantHT, tauxTva);
	}

	public Devis() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Devis [dateCreation=" + dateCreation + ", ref=" + ref + ", montantHT=" + montantHT + ", tauxTva="
				+ tauxTva + ", montantTTC=" + montantTTC + "]";
	}

}
