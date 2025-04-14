package com.br.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.app.entity.Sample;
import com.br.app.repository.SampleRepository;

@Service
public class SampleService {
		private final SampleRepository sampleRepository;  // 생성자 주입

		public SampleService(SampleRepository sampleRepository) { // 생성자
			this.sampleRepository = sampleRepository;
		}
		// 서비스 구현 => 서비스 로직 구성
		// 목록 조회 => getAllSamples()
		// select * from sample; => .findAll();
		// 제네릭: 타입과 관계없이 아무 타입이나 처리나 저장이 가능한 데이터 클래스 => 컬렉션프레임워크
		// 컬렉션프레임워크(모음) = List: ArrayList , Set: HashSet , Map: HashMap, Deque, Queue, Stack,...
		// Hash = 속도 빠름
		// ex) List<Student> stList = new ArrayList<Student>();
		// 		  Student st2 = new Student();
		//       Student st3 = new Student();
		//       stList.add(st2);
		//       stList.add(st3);
		//       for(Student st:stList) {   // 컬렉션프레임워크의 순회 방식   }
		// List<> = 배열
		
		public List<Sample> getAllSamples() {
			return sampleRepository.findAll();    
			// List<Sample> sampleList = new ArrayList<Sample>();
			// sampleRepository = sampleList
		}
		
		// 샘플 1건 조회(no로 조회) => getSampleById(Long no)
		// select * from sample where no=1; => .findById(no); => sampleController
		public Optional<Sample> getSampleById(Long no) {
			return sampleRepository.findById(no);
			// Sample sample = new Sample();
			// sampleRepository = sample
		}
		
		//	샘플 저장(sample 객체로 전달 받아 저장) => savaSample(Sample sample)
		// insert into sample values (값1, 값2); => .save(sample);
		public Sample saveSample(Sample sample) {
			return sampleRepository.save(sample);
		}
		
		// 샘플 수정(sample)
		// update sample set name="" where no=1; => .save(sample)
		public Sample updateSample(Sample sample) {
			return sampleRepository.save(sample);
		}
		
		// 샘플 삭제(no로 삭제) => deleteById(Long no)
		// delete from sample where no=1; => .deleteById(no);
		public void deleteSample(Long no) {
			sampleRepository.deleteById(no);
		}

		// RestApiController의 샘플 상세보기
		public Sample getSampleByNo(Long no) {
			return sampleRepository.findById(no).orElse(null);
			// orElse(null) = Optional
		}
}
