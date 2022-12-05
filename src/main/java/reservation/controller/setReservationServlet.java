package reservation.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import reservation.service.ReserveTimeService;
import reservation.vo.ReserveTimeVO;

@WebServlet("/restaurant/setReservation")
public class setReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReserveTimeService service;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<List<ReserveTimeVO>>() {
		}.getType();
		List<ReserveTimeVO> reserveTimeList = gson.fromJson(req.getReader(), type);
		System.out.println(reserveTimeList);
//		JsonArray jarray = gson.toJsonTree(reserveTimeList).getAsJsonArray();
//		JsonObject jsonObject = new JsonObject();
//		jsonObject.add("reserveTime", jarray);
		
		
//		res.getWriter().write(jsonObject.toString());	
		

	}
}
