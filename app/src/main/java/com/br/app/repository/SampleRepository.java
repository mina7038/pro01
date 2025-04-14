package com.br.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.app.entity.Sample;

// JpaRepository 안에 sql 구문이 다 들어있음
// 인터페이스끼리 상속은 extends                                         // <엔터티이름, 기본키타입>
public interface SampleRepository extends JpaRepository<Sample, Long> {
		
}
