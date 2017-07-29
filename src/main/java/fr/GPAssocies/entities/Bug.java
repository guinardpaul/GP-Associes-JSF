package fr.GPAssocies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

@Entity
public class Bug {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate dateCreation;
	@Size(min=1, message="Description vide!")
	private String descriptionBug;

	public Bug() {
		super();
	}

	public Bug(LocalDate dateCreation, String descriptionBug) {
		super();
		this.dateCreation = dateCreation;
		this.descriptionBug = descriptionBug;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescriptionBug() {
		return descriptionBug;
	}

	public void setDescriptionBug(String descriptionBug) {
		this.descriptionBug = descriptionBug;
	}

	@Override
	public String toString() {
		return "Bug [id=" + id + ", dateCreation=" + dateCreation + ", descriptionBug=" + descriptionBug + "]";
	}

}
