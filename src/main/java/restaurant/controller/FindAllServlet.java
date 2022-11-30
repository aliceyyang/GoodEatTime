package restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.service.RestaurantService;
import restaurant.service.RestaurantServiceImpl;
import restaurant.vo.RestaurantVO;

@WebServlet("/restaurant/findAll")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req, res);
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		
		RestaurantService service;
		try {
			service = new RestaurantServiceImpl();
			List<RestaurantVO> list = service.getAll();
			HttpSession session = req.getSession();
			session.setAttribute("list", list);
			req.getRequestDispatcher("../restaurant/RestaurantFindAll.jsp").forward(req, res);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
