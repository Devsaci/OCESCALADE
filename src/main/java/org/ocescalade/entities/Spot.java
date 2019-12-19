package org.ocescalade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Spot implements Serializable{

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpot;
    @NotNull
    @Size(min = 3, max = 100)
    private String nomSpot;
    @NotNull
    @Size(min = 3, max = 500)
    private String descriptionSite;
    @OneToMany(mappedBy = "spot", fetch = FetchType.LAZY)
    private Collection<Secteur> secteurs;
    @OneToMany(mappedBy = "spot", fetch = FetchType.LAZY)
    private Collection<Commentaire> commentaires;
    
	public Spot() {
		super();
	}
	public Spot(@NotNull @Size(min = 3, max = 100) String nomSpot,
			@NotNull @Size(min = 3, max = 500) String descriptionSite) {
		super();
		this.nomSpot = nomSpot;
		this.descriptionSite = descriptionSite;
	}

	public int getIdSpot() {
		return idSpot;
	}
	public void setIdSpot(int idSpot) {
		this.idSpot = idSpot;
	}
	public String getNomSpot() {
		return nomSpot;
	}
	public void setNomSpot(String nomSpot) {
		this.nomSpot = nomSpot;
	}
	public String getDescriptionSite() {
		return descriptionSite;
	}
	public void setDescriptionSite(String descriptionSite) {
		this.descriptionSite = descriptionSite;
	}
	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}
	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	
}
