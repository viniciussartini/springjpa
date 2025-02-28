package br.com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.springjpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
