package org.ocescalade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Secteur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 3, max = 100)
	private String nomSecteur;
	@NotNull
	@Size(min = 3, max = 1000)
	private String descriptionSecteur;
	@ManyToOne
	@JoinColumn(name = "idSpot")
	private Spot spot;
	@OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
	private Collection<Voie> voies;

	public Secteur() {
		super();
	}

	public Secteur(@NotNull @Size(min = 3, max = 100) String nomSecteur,
			@NotNull @Size(min = 3, max = 1000) String descriptionSecteur, Spot spot) {
		super();
		this.nomSecteur = nomSecteur;
		this.descriptionSecteur = descriptionSecteur;
		this.spot = spot;
	}

	public int getId() {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getNomSecteur() {
		return nomSecteur;
	}

	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public String getDescriptionSecteur() {
		return descriptionSecteur;
	}

	public void setDescriptionSecteur(String descriptionSecteur) {
		this.descriptionSecteur = descriptionSecteur;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public Collection<Voie> getVoies() {
		return voies;
	}

	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}

}
