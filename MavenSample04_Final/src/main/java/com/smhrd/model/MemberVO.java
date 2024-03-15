package com.smhrd.model;

public class MemberVO {
	
	// 1. 필드
	// >> 필드명도 테이블의 column 명과 일치시키자.
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	
	// 2. 메소드
	// 기본생성자, 모든 필드값을 초기화 시킬 수 있는 생성자, getter, setter 메소드
	// alt shift s
	
	//기본생성자
	public MemberVO() {
		super();
	}
	
	// 모든 필드값 초기화 시킬 수 있는 생성자
	public MemberVO(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
		}
	
	// getter, setter 메소드
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
