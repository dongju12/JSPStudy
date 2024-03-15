package com.smhrd.frontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.MemberVO;

@WebServlet("/Ajax")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("요청이 들어옴");
		// 비동기통신으로 들어온 데이터 꺼내오기
		// Ajax?sendData=안녕
		String data = request.getParameter("sendData");
		System.out.println("데이터 확인 >> " + data);
		
		// DAO 사용해서 DB 데이터조회하기
		// 조회 성공!!
		// 결과값을 반환~~
		// ★★★★ 비동기통신을 통해서 결과값을 반환하기 위해서는 
		// 화면에 반환하고 싶은 데이터가 출력되면 된다 ★★★★
		
		// 출력해줄 때 한글인코딩 잡는 방법
		response.setContentType("text/html;charset=UTF-8");
		// 1) 출력객체 꺼내오기
		PrintWriter out = response.getWriter();
		// 2) 출력해주기
		// 조회한 결과 >> email값, tel, address
		// *돌려줘야하는 데이터가 여러개일때*
		MemberVO vo = new MemberVO();
		vo.setEmail("admin");
		vo.setTel("0101234567");
		vo.setAddress("광주광역시");
		
		// java 객체 --> java 객체 변환
		// json 형태로 변환
		
		// 변환하는 도구 꺼내오기
		Gson gson = new Gson();
		// 도구 사용하기
		String json = gson.toJson(vo);
		
		out.print(json);
		
		
		
		
	}

}
