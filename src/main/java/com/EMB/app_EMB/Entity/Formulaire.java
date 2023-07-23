package com.EMB.app_EMB.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name="Formulaires")
@AllArgsConstructor
@NoArgsConstructor
public class Formulaire {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String titre; 
    @NonNull
    private String sujet;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_utilisateur")
    private User visiteur;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public User getVisiteur() {
		return visiteur;
	}


	public void setVisiteur(User visiteur) {
		this.visiteur = visiteur;
	}
    
    
}
