package com.br.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.app.entity.Cart;
import com.br.app.repository.CartRepository;

@Service
public class CartService {
	private final CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
		public List<Cart> findAll(){
			return cartRepository.findAll();
		}
		// 제품 추가
		public void add(Cart cart) {
			cartRepository.save(cart);
		}
		
		// 제품 삭제
		public void delete(Long cno) {
			cartRepository.deleteById(cno);
		}
		
		public void update(Long cno, int amount) {
			Cart cart = cartRepository.findById(cno).orElseThrow();
			cart.setAmount(amount);
	        cartRepository.save(cart);
		}
		
}
