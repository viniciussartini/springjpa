package br.com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.springjpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
