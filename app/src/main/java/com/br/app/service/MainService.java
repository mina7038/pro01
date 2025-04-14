package com.br.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.app.entity.Board;
import com.br.app.entity.Product;
import com.br.app.entity.Qna;
import com.br.app.repository.BoardRepository;
import com.br.app.repository.ProductRepository;
import com.br.app.repository.QnaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {
	private final ProductRepository productRepository;
	private final BoardRepository boardRepository;
	private final QnaRepository qnaRepository;
	
	public List<Product> getLatestProducts(){
		return productRepository.findTop3ByOrderByResdateDesc();
	}
	public List<Board> getLatestBoards(){
		return boardRepository.findTop3ByOrderByResdateDesc();
	}
	public List<Qna> getLatestQnas(){
		return qnaRepository.findTop3ByLevelOrderByResdateDesc(1);
	}
}
