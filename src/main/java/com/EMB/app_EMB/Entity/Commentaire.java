package com.EMB.app_EMB.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name="Commentaires")
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@NonNull
	private String texte;
	
	@Column(name = "send_date")
    private LocalDateTime sendDate;
	
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_visiteur")
    private User user;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}


	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@PrePersist
    public void setSendDate() {
        this.sendDate = LocalDateTime.now();
    }
	public LocalDateTime getSendDate() {
		return sendDate;
	}


	
}
