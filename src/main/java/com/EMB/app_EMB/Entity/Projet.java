package com.EMB.app_EMB.Entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="Projets")
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

	@Id
	@GeneratedValue
	private Long id;
	private String nomProjet;
	private String description;
	private boolean status;
	private Categorie categorie;
	private String adresse;
	
	

	private LocalDateTime dateDebut;
	
	@Temporal(value = TemporalType.DATE)
	private Date dateFin;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
	private Client client_projet;
	
    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Image> images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	
	@PrePersist
	public void setDateDebut() {
		this.dateDebut = LocalDateTime.now();
	}

	public Date getDateFin() {
		return dateFin;
	}
	
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Client getClient_projet() {
		return client_projet;
	}

	public void setClient_projet(Client client_projet) {
		this.client_projet = client_projet;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

    
}
