package com.br.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.app.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
