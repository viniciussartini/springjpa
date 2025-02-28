package br.com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.springjpa.entities.OrderItem;
import br.com.example.springjpa.entities.utils.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{
}
