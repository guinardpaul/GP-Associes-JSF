package fr.GPAssocies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;
	@Column(name = "statutClient")
	private boolean statutClient;
	private String civilite;
	@Column(name = "nom")
	@Size(min = 1, message = "Nom vide!")
	private String nom;
	@Column(name = "prenom")
	@Size(min = 1, message = "Prénom vide!")
	private String prenom;
	@Column(name = "adresseFacturation")
	private String adresseFact;
	private String complAdresseFact;
	private String cpFact;
	private String villeFact;
	@Column(name = "adresseChantier")
	private String adresseChantier;
	private String complAdresseChantier;
	private String cpChantier;
	private String villeChantier;
	@Column(name = "email")
	@Email(message = "Email non valide!")
	private String email;
	@Column(name = "numTel")
	private String numTel;
	
	public Client() {
	}

	public Client(String civilite, String nom, String prenom, String adresseFact, String complAdresseFact,
			String cpFact, String villeFact, String adresseChantier, String complAdresseChantier, String cpChantier,
			String villeChantier, String email, String numTel) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseFact = adresseFact;
		this.complAdresseFact = complAdresseFact;
		this.cpFact = cpFact;
		this.villeFact = villeFact;
		this.adresseChantier = adresseChantier;
		this.complAdresseChantier = complAdresseChantier;
		this.cpChantier = cpChantier;
		this.villeChantier = villeChantier;
		this.email = email;
		this.numTel = numTel;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getCpFact() {
		return cpFact;
	}

	public void setCpFact(String cpFact) {
		this.cpFact = cpFact;
	}

	public String getVilleFact() {
		return villeFact;
	}

	public void setVilleFact(String villeFact) {
		this.villeFact = villeFact;
	}

	public String getCpChantier() {
		return cpChantier;
	}

	public void setCpChantier(String cpChantier) {
		this.cpChantier = cpChantier;
	}

	public String getVilleChantier() {
		return villeChantier;
	}

	public void setVilleChantier(String villeChantier) {
		this.villeChantier = villeChantier;
	}

	public String getAdresseFact() {
		return adresseFact;
	}

	public void setAdresseFact(String adresseFact) {
		this.adresseFact = adresseFact;
	}

	public String getComplAdresseFact() {
		return complAdresseFact;
	}

	public void setComplAdresseFact(String complAdresseFact) {
		this.complAdresseFact = complAdresseFact;
	}

	public String getComplAdresseChantier() {
		return complAdresseChantier;
	}

	public void setComplAdresseChantier(String complAdresseChantier) {
		this.complAdresseChantier = complAdresseChantier;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public boolean isStatutClient() {
		return statutClient;
	}

	public void setStatutClient(boolean statutClient) {
		this.statutClient = statutClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseChantier() {
		return adresseChantier;
	}

	public void setAdresseChantier(String adresseChantier) {
		this.adresseChantier = adresseChantier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(civilite + " ");
		builder.append(nom + " ");
		builder.append(prenom);
		builder.append(", adresse Facturation: ");
		builder.append(adresseFact);
		builder.append(" ");
		builder.append(complAdresseFact);
		builder.append(", ");
		builder.append(cpFact);
		builder.append(" ");
		builder.append(villeFact);
		builder.append(", adresse Chantier:");
		builder.append(adresseChantier);
		builder.append(", ");
		builder.append(complAdresseChantier);
		builder.append(", ");
		builder.append(cpChantier);
		builder.append(" ");
		builder.append(villeChantier);
		builder.append(", email: ");
		builder.append(email);
		builder.append(", Tel: ");
		builder.append(numTel);
		builder.append(".");
		return builder.toString();
	}

	

}
