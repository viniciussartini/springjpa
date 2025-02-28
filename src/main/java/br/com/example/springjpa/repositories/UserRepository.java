package br.com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.springjpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
