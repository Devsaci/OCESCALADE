package org.ocescalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Pret implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;	
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
	@ManyToOne
//  @JoinColumn(name = "userEmprunteur")
	private User userEmprunteur;
//	@OneToMany
//	@JoinColumn(name = "userProprietaire")
//	private User userProprietaire;
	/*        */
	public Pret() {
		super();
	}
	/*         */ 
	public Pret(int id, @NotNull @Future(message = "Cette date est passée.") Date debutPret,
			@NotNull @Future(message = "Cette date est passée.") Date finPret, String statut, Topo topo,
			User userEmprunteur) {
		super();
		Id = id;
		this.debutPret = debutPret;
		this.finPret = finPret;
		this.statut = statut;
		this.topo = topo;	
		this.userEmprunteur = userEmprunteur;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	
	
	public User getUserEmprunteur() {
		return userEmprunteur;
	}
	public void setUserEmprunteur(User userEmprunteur) {
		this.userEmprunteur = userEmprunteur;
	}
	
	

}
