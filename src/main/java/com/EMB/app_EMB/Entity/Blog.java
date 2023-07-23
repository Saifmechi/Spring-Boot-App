package com.EMB.app_EMB.Entity;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
@Entity
@Data
@Table(name="Blogs")
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@NonNull
	private String titre;
	
	@NonNull
	private String description;
	
	
	@Column(name = "send_date")
    private LocalDateTime sendDate;
	
	@OneToOne(mappedBy = "blog_image", cascade = CascadeType.ALL)
	private Image image;
	
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires ;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
    @PrePersist
    public void setSendDate() {
        this.sendDate = LocalDateTime.now();
    }
	public LocalDateTime getSendDate() {
		return sendDate;
	}
	
	
}
