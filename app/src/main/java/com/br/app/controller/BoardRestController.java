package com.br.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.app.entity.Board;
import com.br.app.service.BoardService;

@RestController
@RequestMapping("/board/api")
public class BoardRestController {
	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {   // 서비스 생성자 주입
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Board>> getAllBoards() {
		List<Board> boards = boardService.getAllBoards();
		return ResponseEntity.ok(boards);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<Board> getBoard(@PathVariable("no") Long no) {
		Board board = boardService.getBoardById(no);
		return ResponseEntity.ok(board);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Board> saveBoard(@RequestBody Board board) {
		return ResponseEntity.ok(boardService.saveBoard(board));
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Board> updateBoard(@PathVariable("no") Long no, @RequestBody Board board) {
		board.setNo(no);
		return ResponseEntity.ok(boardService.updateBoard(board));
	}
	
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<Void> deleteBoard(@PathVariable("no") Long no) {
		boardService.deleteBoard(no);
		return ResponseEntity.noContent().build();
	}
}
