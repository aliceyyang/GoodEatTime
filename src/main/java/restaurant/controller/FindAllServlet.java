package restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant.service.RestaurantService;
import restaurant.service.RestaurantServiceImpl;
import restaurant.vo.RestaurantVO;

@WebServlet("/restaurant/findAll")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantService service;
		try {
			service = new RestaurantServiceImpl();
			List<RestaurantVO> list = service.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("../index.jsp").forward(req, resp);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
	}
}
