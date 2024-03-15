package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class EmailCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		// 1. 요청 데이터 꺼내오기 (1개)
		String email = request.getParameter("email");
		
		// 2. DAO 생성하기
		DAO dao = new DAO();
		MemberVO vo = new MemberVO();
		// 3. dao.check() 기능 사용하기
		// email값 보내줘야 함 -> check(email)
		String result = dao.check(email);
		// 4. 결과값 반환
		try {
			// try-catch가 필요한 이유는? 
			// >> response.getWriter() 메소드 안에 이미 IOException을 사용하려면
			//	  예외처리를 하라고 잡혀져있기 때문이다.
			//	  (throws 하면 implements Command가 안됨..)
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	

}
