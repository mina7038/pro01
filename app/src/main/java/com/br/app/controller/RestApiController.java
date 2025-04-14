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

import com.br.app.entity.Sample;
import com.br.app.service.SampleService;

//리액트로 만들거야 ~~ restcontroller
//Restful API = 아무거나 요청해도 들어줌
@RestController
@RequestMapping("/api")
public class RestApiController {

		private final SampleService sampleService;  

		public RestApiController(SampleService sampleService) {  // 서비스 생성자 주입
			this.sampleService = sampleService;
		}

		// 샘플 목록
		@GetMapping("/list")         // http://localhost:8081/api/list
		public ResponseEntity<List<Sample>> getAllSamples() {
		List<Sample> samples = sampleService.getAllSamples();
		return ResponseEntity.ok(samples);
				// ResponseEntity = json으로 바꿔줌
		}
		
		// 샘플 상세보기
		@GetMapping("/detail/{no}")      // http://localhost:8081/api/detail/1
		public ResponseEntity<Sample> getSample(@PathVariable("no") Long no) {
			Sample sample = sampleService.getSampleByNo(no);
			return ResponseEntity.ok(sample);
		}
		
		// 샘플 추가
		@PostMapping("/save")     // http://localhost:8081/api/save <= sample(JSON)
		// @RequestBody = json으로 받을 때
		public ResponseEntity<Sample> saveSample(@RequestBody Sample sample){
			return ResponseEntity.ok(sampleService.saveSample(sample));
		}
	
		// 샘플 수정
		@PutMapping("/edit/{no}")  // = @PostMapping   http://localhost:8081/api/edit/1
		public ResponseEntity<Sample> updateSample(@PathVariable("no") Long no, @RequestBody Sample sample) {
			sample.setNo(no);
			return ResponseEntity.ok(sampleService.updateSample(sample));
		}
		
		// 샘플 삭제
		@DeleteMapping("/delete/{no}")    // http://localhost:8081/api/delete/1
			public ResponseEntity<Void> deleteSample(@PathVariable("no") Long no) {
			sampleService.deleteSample(no);
			return ResponseEntity.noContent().build();
			// .noContent().build() = null 처리 방식
		}
		
}
