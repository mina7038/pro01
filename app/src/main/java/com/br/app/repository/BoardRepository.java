package com.br.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.app.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findTop3ByOrderByResdateDesc();
}
