package restaurant.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant.service.RestaurantService;
import restaurant.service.RestaurantServiceImpl;
import restaurant.vo.RestaurantVO;

@WebServlet("/restaurant/getOne")
public class GetOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RestaurantService service = null;
		

		service = new RestaurantServiceImpl();

			
		StringBuffer errorMsg = new StringBuffer();
		String str = req.getParameter("restaurantNo");
		RestaurantVO restaurantVO = null;
		
		try {
			Integer restaurantNo = Integer.parseInt(str);
			restaurantVO = service.getOneRestaurant(errorMsg, restaurantNo);
		}catch(Exception e) {
			errorMsg.append("餐廳編號格式不正確");
		}
		
		
		if(errorMsg.toString().length() > 0) {
			req.setAttribute("errorMsg", errorMsg.toString());
		}else {
			req.setAttribute("vo", restaurantVO);
		}
			
			req.getRequestDispatcher("../RestaurantGetOne.jsp").forward(req, res);
			
	
		
	}
	
	

}
