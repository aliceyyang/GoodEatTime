package reservation.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.connection.ServiceLocator;
import reservation.vo.ReserveTimeVO;
import restaurant.vo.RestaurantVO;

@WebServlet("/ConnectionTest_JNDI2")
public class ConnectionTest_JNDI2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnectionTest_JNDI2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ReserveTimeVO vo = new ReserveTimeVO();
		List<ReserveTimeVO> list = new ArrayList<ReserveTimeVO>();
		String sql = "update reserveTime " + "set weekDay = ? " + "where restaurantNO = ?;";

		try (Connection con = ServiceLocator.getInstance().getDataSource().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, 5);
			ps.setInt(2, 4);

			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) inserted!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
