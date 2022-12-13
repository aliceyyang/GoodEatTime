package com.tibame.tga104.reservation.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@WebServlet("/restaurant/setReservation")
public class SetReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReserveTimeService service;

	@Override
	// 無法autowired
	public void init() throws ServletException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		service = context.getBean(ReserveTimeService.class);
		super.init();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<List<ReserveTimeVO>>() {
		}.getType();
		List<ReserveTimeVO> reserveTimeList = gson.fromJson(req.getReader(), type);
		System.out.println(reserveTimeList);
		
		boolean result = service.setReserveTime(reserveTimeList);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("sucessful", result);

		res.getWriter().write(jsonObject.toString());	

	}
}
