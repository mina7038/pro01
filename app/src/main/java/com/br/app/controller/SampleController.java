package com.br.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.app.entity.Sample;
import com.br.app.service.SampleService;


@Controller
@RequestMapping("/sample")   // 매핑 종류 다 쓸 수 있음
public class SampleController {
		// Entity => Repository => Service => Controller
		private final SampleService sampleService;  

		public SampleController(SampleService sampleService) {  // 서비스 생성자 주입
			this.sampleService = sampleService;
		}
		
		// @PostMapping = 은닉되어야하는 정보 (insert)
		// @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping => @RequestMapping
		// 매핑 어노테이션으로 @매핑어노테이션("url경로") 형식으로 기술하고, 그 아래에 메서드를 구성하면, 해당
		// Model(모델): 전달 저장소 클래스
		// model.addAttribute("저장소명", 저장할 값 또는 식) 
		
		@GetMapping("/list")         // http://localhost:8081/sample/list
		// 요청된 목록 파일 이름이 문자니까 String
		public String getAllSamples(Model model) {
			// model : a태그에 전달
			model.addAttribute("samples", sampleService.getAllSamples());  //sampleService.getAllSamples() = List<Sample>
			return "sample-list";
		}
		
		@GetMapping("/detail/{no}")    // http://localhost:8081/sample/detail/no
		// @PathVariable: 매핑주소의 경로상에 매개변수가 있는 경우
		public String getSampleById(@PathVariable("no") Long no, Model model) {
			model.addAttribute("sample", sampleService.getSampleByNo(no));
			return "sample-detail";
		}
		@GetMapping("/ins")
		public String getInsForm(Model model) {    // http://localhost:8081/sample/ins
				model.addAttribute("sample", new Sample());
				return "sample-form";
		}
		
		@PostMapping("/save")
		// @ModelAttribute: 객체로 받을 경우 활용되는 어노테이션
		public String saveSample(@ModelAttribute Sample sample) {
			sampleService.saveSample(sample);
			return "redirect:/sample/list";
		}
		
		@GetMapping("/edit/{no}")
		public String editForm(@PathVariable("no") Long no, Model model) {
			model.addAttribute("sample", sampleService.getSampleByNo(no));
			return "sample-edit";
		}
		
		@PostMapping("/update/{no}")
		public String updateSample(@PathVariable("no") Long no, @ModelAttribute Sample sample) {
			sample.setNo(no);
			sampleService.updateSample(sample);
			return "redirect:/sample/list";
		}
		
		@GetMapping("/delete/{no}")
		public String deleteSample(@PathVariable("no") Long no) {
			sampleService.deleteSample(no);
			return "redirect:/sample/list";
		}
}
