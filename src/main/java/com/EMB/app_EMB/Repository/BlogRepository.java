package com.EMB.app_EMB.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EMB.app_EMB.Entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>{
	
	public Optional< List<Blog>> findByTitre(String titre);
	
}
