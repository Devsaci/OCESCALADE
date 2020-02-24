package org.ocescalade.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Voie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 3, max = 100)
	private String nomVoie;
	@NotNull
	@Size(min = 3, max = 500)
	private String descriptionVoie;
	@NotNull
	@Size(min = 3, max = 50)
	private String niveauVoie;
	@ManyToOne
	@JoinColumn(name = "idSecteur")
	private Secteur secteur;

	public Voie() {
		super();
	}

	public Voie(@NotNull @Size(min = 3, max = 100) String nomVoie,
			@NotNull @Size(min = 3, max = 500) String descriptionVoie,
			@NotNull @Size(min = 3, max = 50) String niveauVoie, Secteur secteur) {
		super();
		this.nomVoie = nomVoie;
		this.descriptionVoie = descriptionVoie;
		this.niveauVoie = niveauVoie;
		this.secteur = secteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getDescriptionVoie() {
		return descriptionVoie;
	}

	public void setDescriptionVoie(String descriptionVoie) {
		this.descriptionVoie = descriptionVoie;
	}

	public String getNiveauVoie() {
		return niveauVoie;
	}

	public void setNiveauVoie(String niveauVoie) {
		this.niveauVoie = niveauVoie;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

}
