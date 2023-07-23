package com.EMB.app_EMB.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.EMB.app_EMB.Entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
	
	public Optional<Client> findByEmail(String email);

}
