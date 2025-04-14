package com.br.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
public class Board {
	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	// 기본키가 아니면 다 @Column
	@Column(nullable = false, length = 200)
	private String title;
	
	// TEXT라고 정의하면 255자 이상까지 가능
	@Column(columnDefinition = "Text")
	private String content;
	
	@Column(nullable = false, length = 50)
	private String author;
	
	private LocalDateTime resdate;
	
	private int hits;
	
	// 항목의 값을 넣기 전에 기본값 정의
	@PrePersist
	protected void onCreated() {
		this.resdate = this.resdate == null ? LocalDateTime.now() : this.resdate;
		this.hits = 0;
	}
}
