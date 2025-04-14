package com.br.app.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.app.entity.Member;
import com.br.app.repository.MemberRepository;
// 기능 구현은 서비스에서
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	// 암호화
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.memberRepository = memberRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	// 사용자가 입력한 비번을 암호화하여 새로 저장함 
	public void join(Member member) {  // 사용자가 입력한 비밀번호를 암호화하여 새로 저장
		member.setPw(bCryptPasswordEncoder.encode(member.getPw()));   
		memberRepository.save(member);
	}
	// 아이디와 비밀번호 일치하는 회원정보 반환
	public Member login(String id, String pw) {                                      //넣은 비밀번호랑 있던 정보랑 일치한지 확인
		return memberRepository.findById(id).filter(m -> bCryptPasswordEncoder.matches(pw, m.getPw())).orElse(null);
	}
	// 마이페이지 회원 정보
	public Member getMember(String id) {
		return memberRepository.findById(id).orElse(null);
	}
	// 회원번호로 검색
	public Member getMemberByNo(Long no) {
		return memberRepository.findByNo(no).orElse(null);
	}
	// 회원 정보 변경
	public Member update(Member member) {
		return memberRepository.save(member);
	}
	// 비밀번호 변경
	public void updatePassword(Member member) {
		member.setPw(bCryptPasswordEncoder.encode(member.getPw()));
		memberRepository.save(member);
	}
	// 회원 탈퇴
	public void delete(Long no) {
		memberRepository.deleteById(no);
	}
	// 관리자 회원 목록
	public List<Member> getMemberList(){
		return memberRepository.findAll();
	}
	// 아이디가 존재하는지 확인
	public boolean idCheck(String id) {
		return memberRepository.existsById(id);
	}
}
