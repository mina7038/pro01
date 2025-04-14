package com.br.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  // 하나의 테이블이다
@Getter
@Setter
@ToString
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor  // 모든 필드 생성자
@Builder  // Sample sample = new Sample()
public class Sample {
		@Id    // primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY)    //auto_increment(자동 숫자 증가)
		private Long no;
		
		@Column(nullable = false, length = 50)   // nullable : null 가능?
		private String name;
}
