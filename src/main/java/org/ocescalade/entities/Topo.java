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
public class Topo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTopo;
    @NotNull
    @Size(min = 3, max = 50)
    private String nomTopo;
    @NotNull
    @Size(min = 3, max = 500)
    private String descriptionTopo;
    private String nomProprietaire;
    private Boolean isLoan;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @OneToMany(mappedBy = "topo", fetch = FetchType.LAZY)
    private Collection<Pret> prets;
	public Topo() {
		super();
	}
	public Topo(@NotNull @Size(min = 3, max = 50) String nomTopo,
			@NotNull @Size(min = 3, max = 500) String descriptionTopo, String nomProprietaire, Boolean isLoan,
			User user) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.nomProprietaire = nomProprietaire;
		this.isLoan = isLoan;
		this.user = user;
	}
	public int getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(int idTopo) {
		this.idTopo = idTopo;
	}
	public String getNomTopo() {
		return nomTopo;
	}
	public void setNomTopo(String nomTopo) {
		this.nomTopo = nomTopo;
	}
	public String getDescriptionTopo() {
		return descriptionTopo;
	}
	public void setDescriptionTopo(String descriptionTopo) {
		this.descriptionTopo = descriptionTopo;
	}
	public String getNomProprietaire() {
		return nomProprietaire;
	}
	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}
	public Boolean getIsLoan() {
		return isLoan;
	}
	public void setIsLoan(Boolean isLoan) {
		this.isLoan = isLoan;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Pret> getPrets() {
		return prets;
	}
	public void setPrets(Collection<Pret> prets) {
		this.prets = prets;
	}	
    
    
    
	
}
