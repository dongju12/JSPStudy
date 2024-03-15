package com.smhrd.database;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.model.MemberVO;

public class DAO {

	// Data Access Object
	// 데이터에 접근하는 객체

	// 1. 필드
	// DBCP 꺼내오기
	// factory == Connection 객체들을 가지고 있는 공간
	private SqlSessionFactory factory = MySqlSessionManager.getSqlSessionFactory();
	
	public int join(MemberVO vo) {

		// 1. 연결객체 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 연결객체 사용하기
		// *공통*
		// 매개변수 한개 >> Mapper파일의 sql구문 id값
		// 매개변수 두개 >> id값, 보내줘야하는 데이터
		// session.insert() : insert구문
		// session.delete() : delete구문
		// session.update() : update구문
		// session.selectOne() : select구문인데, 가져와야하는 데이터가 한 개일 때 사용
		// session.selectList() : select구문인데, 가져와야하는 데이터가 여러 개일 때 사용
		int row = session.insert("join", vo);
		// 3. 연결객체 반납하기
		session.close();
		
		
		return row;
	}
	
	
	
	public MemberVO login(MemberVO vo) {
		
		// 1. 연결객체 빌려오기
		// select니까 매개변수 없어도 됨
		SqlSession session = factory.openSession();
		
		// 2. 연결객체 사용하기 >> select >> 데이터가 한개
		// "login" : mapper 파일 안에 있는 sql구문 중 어떤 거 쓸 건지
		// vo : 보내줘야하는 데이터
		MemberVO resultVo = session.selectOne("login", vo);
		// --> select기능을 수행하고 난 결과 자료형은 제네릭 기법으로 결정된다.
		// 제네릭 기법이란?
		// : 클래스 내부(SqlSession)에서 사용해야하는 자료형을 클래스 외부(DAO)에서 결정하는 기법
		
		// 3. 연결객체 반납하기
		session.close();

		// 4. 결과값 반환
		return resultVo;

	}
	
	


	public List<MemberVO> selectAll() {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession();
		
		
		// 2. 연결객체 사용하기
		List<MemberVO> resultList = session.selectList("selectAll");
		// MemberVO --> 회원 1명에 대한 정보
		// 우리가 필요한 건? 회원 여러명에 대한 정보 --> 몇명일지 알 수 없다.
		// MemberVO 하나로 묶어서 표현하는 자료구조 중에 가변적인? >> ArrayList >> List
		// List란?
		// --> ArrayList의 상위 클래스
		// --> 더 추상적인 클래스 
		// ** Collection 구조 ** 
		
		// 3. 연결객체 반납하기
		session.close();
		
		// 4. 결과값 반환하기
		return resultList;
		
	}

	
	
	
}
