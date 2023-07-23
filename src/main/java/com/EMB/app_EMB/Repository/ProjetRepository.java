package com.EMB.app_EMB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EMB.app_EMB.Entity.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long>{

}
