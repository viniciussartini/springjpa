package br.com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.springjpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
