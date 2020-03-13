package org.ocescalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Pret implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String emprunteur;
	private String proprietaire;
	private String nomDuTopo;
	@NotNull
	@Future(message = "Cette date est passée.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date debutPret;
	@NotNull
	@Future(message = "Cette date est passée.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date finPret;
	private String statut;
	@ManyToOne
	@JoinColumn(name = "topoPret")
	private Topo topo;
	
	

	public Pret() {
		super();
	}

	public Pret(String emprunteur, String proprietaire, String nomDuTopo,
			@NotNull @Future(message = "Cette date est passée.") Date debutPret,
			@NotNull @Future(message = "Cette date est passée.") Date finPret, String statut, Topo topo) {
		super();
		this.emprunteur = emprunteur;
		this.proprietaire = proprietaire;
		this.nomDuTopo = nomDuTopo;
		this.debutPret = debutPret;
		this.finPret = finPret;
		this.statut = statut;
		this.topo = topo;
	}
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(String emprunteur) {
		this.emprunteur = emprunteur;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getNomDuTopo() {
		return nomDuTopo;
	}
	public void setNomDuTopo(String nomDuTopo) {
		this.nomDuTopo = nomDuTopo;
	}
	public Date getDebutPret() {
		return debutPret;
	}
	public void setDebutPret(Date debutPret) {
		this.debutPret = debutPret;
	}
	public Date getFinPret() {
		return finPret;
	}
	public void setFinPret(Date finPret) {
		this.finPret = finPret;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
	
	
	

}
