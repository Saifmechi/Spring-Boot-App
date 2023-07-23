package com.EMB.app_EMB.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

	private String content;

    @Column(name = "send_date")
    private LocalDateTime sendDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;
    
    
    @PrePersist
    public void setSendDate() {
        this.sendDate = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getSendDate() {
		return sendDate;
	}
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}

