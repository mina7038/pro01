package com.br.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.app.entity.Product;
import com.br.app.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// 제품 목록
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	// 제품 1건 상세보기
	public Product findById(Long no) {
		return productRepository.findById(no).orElse(null);
	}
	
	// 제품 추가
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	// 제품 정보 변경
	public Product update(Product product) {
		return productRepository.save(product);
	}
	
	// 제품 삭제
	public void delete(Long no) {
		productRepository.deleteById(no);
	}
	
}	
