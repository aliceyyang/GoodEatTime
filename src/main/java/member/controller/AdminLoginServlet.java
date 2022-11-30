package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member.service.AdminService;
import member.service.impl.AdminServiceImpl;
import member.vo.AdminVO;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service;
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			service = new AdminServiceImpl();
		} catch (Exception e) {
		}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		AdminVO adminVO= gson.fromJson(request.getReader(), AdminVO.class);
		adminVO = service.login(adminVO);
		JsonObject resultObj = new JsonObject();
		if (adminVO != null) {
			request.getSession().setAttribute("adminVO", adminVO);
		}
		resultObj.addProperty("successful", adminVO != null);
		response.getWriter().write(resultObj.toString());
	}
	
   
	
	


}
