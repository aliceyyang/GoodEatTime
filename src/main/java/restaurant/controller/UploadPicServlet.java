package restaurant.controller;

import java.io.IOException;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import restaurant.service.RestaurantPicService;
import restaurant.service.impl.RestaurantPicServiceImpl;

@WebServlet("/restaurant/UploadPic")
@MultipartConfig
public class UploadPicServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Integer restaurantNo = Integer.valueOf(req.getParameter("restaurantNo"));
		Part part = req.getPart("file");
		byte[] file = part.getInputStream().readAllBytes();
		String restaurantPicRemark = req.getParameter("restaurantPicRemark");
		
		RestaurantPicService service = new RestaurantPicServiceImpl();
		service.addRestaurantPic(restaurantNo, file, restaurantPicRemark);
		HttpSession session = req.getSession();
//		session = SetAttribute();
		req.getRequestDispatcher("../restaurant/RestaurantUploadPic.jsp").forward(req, res);
	}
	
	
}
