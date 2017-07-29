package fr.GPAssocies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDate;

@Entity
@Table(name = "factureGlobal")
public class FactureGlobal extends AbsDevFact {
	@Column(name = "statutFactGlobal")
	private boolean statutFactG;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Devis devis;

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Client getClient() {
		return client;
	}

	public boolean isStatutFactG() {
		return statutFactG;
	}

	public void setStatutFactG(boolean statutFactG) {
		this.statutFactG = statutFactG;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public FactureGlobal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FactureGlobal(String ref, LocalDate dateCreation, double montantHT, double tauxTva) {
		super(ref, dateCreation, montantHT, tauxTva);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ref : ");
		builder.append(ref);
		builder.append(", dateCreation : ");
		builder.append(dateCreation);
		builder.append(", montantHT : ");
		builder.append(montantHT);
		builder.append(", tauxTva : ");
		builder.append(tauxTva);
		builder.append(", montantTTC : ");
		builder.append(montantTTC);
		builder.append(", devis : ");
		builder.append(devis.getRef());

		return builder.toString();
	}

}
