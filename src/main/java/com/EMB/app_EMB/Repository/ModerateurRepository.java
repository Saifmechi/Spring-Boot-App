package com.EMB.app_EMB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EMB.app_EMB.Entity.Moderateur;

@Repository
public interface ModerateurRepository extends JpaRepository<Moderateur,Long>{

}
