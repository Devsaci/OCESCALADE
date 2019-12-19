package org.ocescalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCom;
	@NotNull
	@Size(min = 3, max = 100)
	private String titre;
	@NotNull
	@Size(min = 3, max = 1000)
	private String message;
	@NotNull
	@Size(min = 3, max = 100)
	private String auteur;
	@ManyToOne
	@JoinColumn(name = "refSpot")
	private Spot spot;

	public Commentaire() {
		super();
	}

	public Commentaire( @NotNull @Size(min = 3, max = 100) String titre,
						@NotNull @Size(min = 3, max = 1000) String message, 
						@NotNull @Size(min = 3, max = 100) String auteur,
			Spot spot) {
		super();
		this.titre = titre;
		this.message = message;
		this.auteur = auteur;
		this.spot = spot;
	}

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

}
