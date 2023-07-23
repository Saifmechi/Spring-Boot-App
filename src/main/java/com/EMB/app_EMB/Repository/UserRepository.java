package com.EMB.app_EMB.Repository;


import java.util.Optional;

import com.EMB.app_EMB.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}