package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class Update implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// UPDATE B_MEMBER SET PW = ?, TEL = ?, ADDRESS = ? WHERE EMAIL = ?
		// 1. 요청 데이터 수집하기
		// --> 3개 + email data(session)
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		/////////////////////////////////////////////////
		MemberVO sessionVo = (MemberVO)(request.getSession().getAttribute("member"));
		String email = sessionVo.getEmail();
		
		// 2. 데이터 하나로 묶어주기
		MemberVO vo = new MemberVO(email,pw,tel,address);
		
		// 3. DAO 생성하기
		DAO dao = new DAO();
		
		// 4. dao.update 기능 사용하기
		dao.update(vo);

		// * session 안에 있는 데이터를 수정한 데이터로 변경
		request.getSession().setAttribute("member", vo);
		
		// 5. main.jsp로 redirect 방식으로 이동하기
		return "redirect:/gomain.do";
	}

	
	
	
}
