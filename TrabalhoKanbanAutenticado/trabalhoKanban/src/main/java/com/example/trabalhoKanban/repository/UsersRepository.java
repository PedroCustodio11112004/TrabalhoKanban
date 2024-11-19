package com.example.trabalhoKanban.repository;

import com.example.trabalhoKanban.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    UserDetails findByLogin(String login);
}
