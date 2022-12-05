package product.controller;

import javax.naming.NamingException;

import com.google.gson.Gson;

import common.connection.HibernateUtil;
import reservation.dao.ReserveTimeDao;
import reservation.dao.impl.ReserveTimeDaoImpl;
import reservation.vo.ReserveTimeVO;

public class TestJsonArray {

	public static void main(String[] args) throws NamingException {
		String input = "["
				+ "{'reserveTime':'12:00', 'allowReserveNum': 1},"
				+ "{'reserveTime':'13:00', 'allowReserveNum': 2},"
				+ "{'reserveTime':'18:00', 'allowReserveNum': 3},"
				+ "{'reserveTime':'19:00', 'allowReserveNum': 3}"
				+ "]";
		
		ReserveTimeDao dao = new ReserveTimeDaoImpl(HibernateUtil.getSessionFactory());
		Gson gson = new Gson();
		ReserveTimeVO[] target = gson.fromJson(input, ReserveTimeVO[].class);
		for(ReserveTimeVO r : target) {
			r.setRestaurantNo(1);
			r.setWeekDay(0);
			dao.insert(r);
			System.out.println(r);
		}
	}
//	'reserveTimeNo': 1, 'restaurantNo' : 1, 'weekDay': 0, 
}
