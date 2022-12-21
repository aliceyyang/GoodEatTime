package com.tibame.tga104.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tibame.tga104.member.service.AdminService;
import com.tibame.tga104.member.vo.AdminVO;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminService service;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson gson = new Gson();
		AdminVO adminVO = gson.fromJson(request.getReader(), AdminVO.class);
		adminVO = service.login(adminVO);
		JsonObject resultObj = new JsonObject();
		if (adminVO != null) {
			request.getSession().setAttribute("adminVO", adminVO);
		}
		resultObj.addProperty("successful", adminVO != null);
		response.getWriter().write(resultObj.toString());
	}

//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("aaa");
//	}

}
