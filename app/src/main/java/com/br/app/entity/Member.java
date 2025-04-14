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


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@Column(unique = true, nullable = false, length = 100)
	private String id;
	
	@Column(nullable = false)
	private String pw;    // 암호화 필요
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 15)
	private String tel;
	
	@Column(nullable = false)
	private String email; 
}
