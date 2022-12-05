package order.dao;

import static common.connection.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import order.vo.ProdOrderVO;

public class ProdOrderJDBCDAO implements ProdOrderDAO_interface{
	
	public static void main(String[] args) {
		
		ProdOrderJDBCDAO dao_prodOrder = new ProdOrderJDBCDAO();
		
		// 新增資料。
		ProdOrderVO prodOrderVO_insert = new ProdOrderVO();
		prodOrderVO_insert.setMemberNo(6);
		prodOrderVO_insert.setRestaurantNo(6);
		prodOrderVO_insert.setCouponNo(0);
		prodOrderVO_insert.setOrderStatus("訂單成立");
		prodOrderVO_insert.setProdOrderDate(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
		prodOrderVO_insert.setProdOrderReveiveTime(java.sql.Timestamp.valueOf("2022-11-28 05:46:00"));
		prodOrderVO_insert.setProdOderDeliverTime(java.sql.Timestamp.valueOf("2022-11-28 10:46:00"));
		prodOrderVO_insert.setDeliverFee(0);
		prodOrderVO_insert.setAmountBeforeCoupon(500);
		prodOrderVO_insert.setAmountAfterCoupon(500);
		prodOrderVO_insert.setProdOrderPoint(0);
		prodOrderVO_insert.setProdOrderReceiverName("李佳欣");
		prodOrderVO_insert.setProdOrderReceiverTel("0958-345678");
		prodOrderVO_insert.setProdOrderReceiverMail("tibame6@gmail.com");
		prodOrderVO_insert.setProdOrderReceiverAddress("台北市信義區吳興街250號");
		prodOrderVO_insert.setInvoiceNumber("AB-67890123");
		prodOrderVO_insert.setTaxIDNumber(null);
		dao_prodOrder.insert(prodOrderVO_insert);
		
		// 刪除資料。
		dao_prodOrder.delete(5);
		
		// 更新資料。
		ProdOrderVO prodOrderVO_update = new ProdOrderVO();
		prodOrderVO_update.setMemberNo(6);
		prodOrderVO_update.setRestaurantNo(6);
		prodOrderVO_update.setCouponNo(0);
		prodOrderVO_update.setOrderStatus("已取貨");
		prodOrderVO_update.setProdOrderDate(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
		prodOrderVO_update.setProdOrderReveiveTime(java.sql.Timestamp.valueOf("2022-11-28 05:46:00"));
		prodOrderVO_update.setProdOderDeliverTime(java.sql.Timestamp.valueOf("2022-11-28 10:46:00"));
		prodOrderVO_update.setDeliverFee(0);
		prodOrderVO_update.setAmountBeforeCoupon(500);
		prodOrderVO_update.setAmountAfterCoupon(500);
		prodOrderVO_update.setProdOrderPoint(0);
		prodOrderVO_update.setProdOrderReceiverName("李佳欣");
		prodOrderVO_update.setProdOrderReceiverTel("0958-345678");
		prodOrderVO_update.setProdOrderReceiverMail("tibame6@gmail.com");
		prodOrderVO_update.setProdOrderReceiverAddress("台北市信義區吳興街250號");
		prodOrderVO_update.setInvoiceNumber("AB-67890123");
		prodOrderVO_update.setTaxIDNumber(null);
		prodOrderVO_update.setProdOrderNo(6);
		dao_prodOrder.update(prodOrderVO_update);
		
		// 查詢單筆資料 "where prodOrderNo = ? "。
		ProdOrderVO prodOrderVO_select_rs = dao_prodOrder.select(6);
		System.out.print(prodOrderVO_select_rs.getProdOrderNo() + " ,");
		System.out.print(prodOrderVO_select_rs.getMemberNo() + " ,");
		System.out.print(prodOrderVO_select_rs.getRestaurantNo() + " ,");
		System.out.print(prodOrderVO_select_rs.getCouponNo() + " ,");
		System.out.print(prodOrderVO_select_rs.getOrderStatus() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderDate() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderReveiveTime() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOderDeliverTime() + " ,");
		System.out.print(prodOrderVO_select_rs.getDeliverFee() + " ,");
		System.out.print(prodOrderVO_select_rs.getAmountBeforeCoupon() + " ,");
		System.out.print(prodOrderVO_select_rs.getAmountAfterCoupon() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderPoint() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderReceiverName() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderReceiverTel() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderReceiverMail() + " ,");
		System.out.print(prodOrderVO_select_rs.getProdOrderReceiverAddress() + " ,");
		System.out.print(prodOrderVO_select_rs.getInvoiceNumber() + " ,");
		System.out.println(prodOrderVO_select_rs.getTaxIDNumber());
		
		// 查詢多筆資料。 "where prodOrderNo = ? "。
		List<ProdOrderVO> prodOrderVO_list = dao_prodOrder.getAll();
		// 如果改建構子，下列可註解掉。
		for(ProdOrderVO prodOrderVO_getAll : prodOrderVO_list) {
			
			System.out.print(prodOrderVO_getAll.getProdOrderNo() + " ,");
			System.out.print(prodOrderVO_getAll.getMemberNo() + " ,");
			System.out.print(prodOrderVO_getAll.getRestaurantNo() + " ,");
			System.out.print(prodOrderVO_getAll.getCouponNo() + " ,");
			System.out.print(prodOrderVO_getAll.getOrderStatus() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderDate() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderReveiveTime() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOderDeliverTime() + " ,");
			System.out.print(prodOrderVO_getAll.getDeliverFee() + " ,");
			System.out.print(prodOrderVO_getAll.getAmountBeforeCoupon() + " ,");
			System.out.print(prodOrderVO_getAll.getAmountAfterCoupon() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderPoint() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderReceiverName() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderReceiverTel() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderReceiverMail() + " ,");
			System.out.print(prodOrderVO_getAll.getProdOrderReceiverAddress() + " ,");
			System.out.print(prodOrderVO_getAll.getInvoiceNumber() + " ,");
			System.out.println(prodOrderVO_getAll.getTaxIDNumber());
			
		}
		
	}
	
	public void insert(ProdOrderVO prodOrderVO) {
		
		String sql_insert = "insert into prodOrder (memberNo, restaurantNo, couponNo, orderStatus, prodOrderDate, prodOrderReveiveTime, prodOderDeliverTime, deliverFee, amountBeforeCoupon, amountAfterCoupon, prodOrderPoint, prodOrderReceiverName, prodOrderReceiverTel, prodOrderReceiverMail, prodOrderReceiverAddress, invoiceNumber, taxIDNumber) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql_insert)){
			
			ps.setInt(1, prodOrderVO.getMemberNo());
			ps.setInt(2, prodOrderVO.getRestaurantNo());
			ps.setInt(3, prodOrderVO.getCouponNo());
			ps.setString(4, prodOrderVO.getOrderStatus());
			ps.setTimestamp(5, prodOrderVO.getProdOrderDate());
			ps.setTimestamp(6, prodOrderVO.getProdOrderReveiveTime());
			ps.setTimestamp(7, prodOrderVO.getProdOderDeliverTime());
			ps.setInt(8, prodOrderVO.getDeliverFee());
			ps.setInt(9, prodOrderVO.getAmountBeforeCoupon());
			ps.setInt(10, prodOrderVO.getAmountAfterCoupon());
			ps.setInt(11, prodOrderVO.getProdOrderPoint());
			ps.setString(12, prodOrderVO.getProdOrderReceiverName());
			ps.setString(13, prodOrderVO.getProdOrderReceiverTel());
			ps.setString(14, prodOrderVO.getProdOrderReceiverMail());
			ps.setString(15, prodOrderVO.getProdOrderReceiverAddress());
			ps.setString(16, prodOrderVO.getInvoiceNumber());
			ps.setString(17, prodOrderVO.getTaxIDNumber());			
			System.out.println("成功筆數為：" + ps.executeUpdate());
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
	};
	public void delete(Integer prodOrderNo) {
		
		String sql_delete = "delete from prodOrder "
				+ "where "
				+ "	prodOrderNo = ? ";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql_delete)){
			
			ps.setInt(1, prodOrderNo);
			System.out.println("成功筆數為：" + ps.executeUpdate());					
			
		} catch (Exception e) {
			System.out.println(e);
		}
	};
	public void update(ProdOrderVO prodOrderVO) {
		
		String sql_update = "update prodOrder "
				+ "set "
				+ " memberNo = ?,"
				+ "	restaurantNo = ?,"
				+ "	couponNo = ?,"
				+ "	orderStatus = ?,"
				+ "	prodOrderDate = ?,"
				+ "	prodOrderReveiveTime = ?,"
				+ "	prodOderDeliverTime = ?,"
				+ "	deliverFee = ?,"
				+ "	amountBeforeCoupon = ?,"
				+ "	amountAfterCoupon = ?,"
				+ "	prodOrderPoint = ?,"
				+ "	prodOrderReceiverName = ?,"
				+ "	prodOrderReceiverTel = ?,"
				+ "	prodOrderReceiverMail = ?,"
				+ "	prodOrderReceiverAddress = ?,"
				+ "	invoiceNumber = ?,"
				+ "	taxIDNumber = ? "
				+ "where "
				+ "	prodOrderNo = ? ";
		
		
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql_update)){
			
			ps.setInt(1, prodOrderVO.getMemberNo());
			ps.setInt(2, prodOrderVO.getRestaurantNo());
			ps.setInt(3, prodOrderVO.getCouponNo());
			ps.setString(4, prodOrderVO.getOrderStatus());
			ps.setTimestamp(5, prodOrderVO.getProdOrderDate());
			ps.setTimestamp(6, prodOrderVO.getProdOrderReveiveTime());
			ps.setTimestamp(7, prodOrderVO.getProdOderDeliverTime());
			ps.setInt(8, prodOrderVO.getDeliverFee());
			ps.setInt(9, prodOrderVO.getAmountBeforeCoupon());
			ps.setInt(10, prodOrderVO.getAmountAfterCoupon());
			ps.setInt(11, prodOrderVO.getProdOrderPoint());
			ps.setString(12, prodOrderVO.getProdOrderReceiverName());
			ps.setString(13, prodOrderVO.getProdOrderReceiverTel());
			ps.setString(14, prodOrderVO.getProdOrderReceiverMail());
			ps.setString(15, prodOrderVO.getProdOrderReceiverAddress());
			ps.setString(16, prodOrderVO.getInvoiceNumber());
			ps.setString(17, prodOrderVO.getTaxIDNumber());
			ps.setInt(18, prodOrderVO.getProdOrderNo());
			System.out.println("成功筆數為：" + ps.executeUpdate());
						
		} catch (Exception e) {
			System.out.println(e);
		}
		
	};
	public ProdOrderVO select(Integer prodOrderNo){
		
		String sql_select = "select "
				+ "	prodOrderNo, "
				+ "	memberNo, "
				+ "	restaurantNo, "
				+ "	couponNo, "
				+ "	orderStatus, "
				+ "	prodOrderDate, "
				+ "	prodOrderReveiveTime, "
				+ "	prodOderDeliverTime, "
				+ "	deliverFee, "
				+ "	amountBeforeCoupon, "
				+ "	amountAfterCoupon, "
				+ "	prodOrderPoint, "
				+ "	prodOrderReceiverName, "
				+ "	prodOrderReceiverTel, "
				+ "	prodOrderReceiverMail, "
				+ "	prodOrderReceiverAddress, "
				+ "	invoiceNumber, "
				+ "	taxIDNumber "
				+ "from prodOrder "
				+ "where prodOrderNo = ? ";
		
		ProdOrderVO prodOrderVO_select = new ProdOrderVO();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql_select)){
			
			ps.setInt(1, prodOrderNo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {				
				prodOrderVO_select.setProdOrderNo(rs.getInt("prodOrderNo"));
				prodOrderVO_select.setMemberNo(rs.getInt("memberNo"));
				prodOrderVO_select.setRestaurantNo(rs.getInt("restaurantNo"));
				prodOrderVO_select.setCouponNo(rs.getInt("couponNo"));
				prodOrderVO_select.setOrderStatus(rs.getString("orderStatus"));
				prodOrderVO_select.setProdOrderDate(rs.getTimestamp("prodOrderDate"));
				prodOrderVO_select.setProdOrderReveiveTime(rs.getTimestamp("prodOrderReveiveTime"));
				prodOrderVO_select.setProdOderDeliverTime(rs.getTimestamp("prodOderDeliverTime"));
				prodOrderVO_select.setDeliverFee(rs.getInt("deliverFee"));
				prodOrderVO_select.setAmountBeforeCoupon(rs.getInt("amountBeforeCoupon"));
				prodOrderVO_select.setAmountAfterCoupon(rs.getInt("amountAfterCoupon"));
				prodOrderVO_select.setProdOrderPoint(rs.getInt("prodOrderPoint"));
				prodOrderVO_select.setProdOrderReceiverName(rs.getString("prodOrderReceiverName"));
				prodOrderVO_select.setProdOrderReceiverTel(rs.getString("prodOrderReceiverTel"));
				prodOrderVO_select.setProdOrderReceiverMail(rs.getString("prodOrderReceiverMail"));
				prodOrderVO_select.setProdOrderReceiverAddress(rs.getString("prodOrderReceiverAddress"));
				prodOrderVO_select.setInvoiceNumber(rs.getString("invoiceNumber"));
				prodOrderVO_select.setTaxIDNumber(rs.getString("taxIDNumber"));				
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return prodOrderVO_select;
	};
	public List<ProdOrderVO> getAll() {
		
		String sql_getAll = "select "
				+ "	prodOrderNo, "
				+ "	memberNo, "
				+ "	restaurantNo, "
				+ "	couponNo, "
				+ "	orderStatus, "
				+ "	prodOrderDate, "
				+ "	prodOrderReveiveTime, "
				+ "	prodOderDeliverTime, "
				+ "	deliverFee, "
				+ "	amountBeforeCoupon, "
				+ "	amountAfterCoupon, "
				+ "	prodOrderPoint, "
				+ "	prodOrderReceiverName, "
				+ "	prodOrderReceiverTel, "
				+ "	prodOrderReceiverMail, "
				+ "	prodOrderReceiverAddress, "
				+ "	invoiceNumber, "
				+ "	taxIDNumber "
				+ "from prodOrder "
				+ "order by prodOrderNo ";
		
		List <ProdOrderVO> prodOrderVO_list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(sql_getAll)){
			
			ResultSet rs = ps.executeQuery();			
			while(rs.next())
			{
				ProdOrderVO prodOrderVO_getAll = new ProdOrderVO();
				prodOrderVO_getAll.setProdOrderNo(rs.getInt("prodOrderNo"));
				prodOrderVO_getAll.setMemberNo(rs.getInt("memberNo"));
				prodOrderVO_getAll.setRestaurantNo(rs.getInt("restaurantNo"));
				prodOrderVO_getAll.setCouponNo(rs.getInt("couponNo"));
				prodOrderVO_getAll.setOrderStatus(rs.getString("orderStatus"));
				prodOrderVO_getAll.setProdOrderDate(rs.getTimestamp("prodOrderDate"));
				prodOrderVO_getAll.setProdOrderReveiveTime(rs.getTimestamp("prodOrderReveiveTime"));
				prodOrderVO_getAll.setProdOderDeliverTime(rs.getTimestamp("prodOderDeliverTime"));
				prodOrderVO_getAll.setDeliverFee(rs.getInt("deliverFee"));
				prodOrderVO_getAll.setAmountBeforeCoupon(rs.getInt("amountBeforeCoupon"));
				prodOrderVO_getAll.setAmountAfterCoupon(rs.getInt("amountAfterCoupon"));
				prodOrderVO_getAll.setProdOrderPoint(rs.getInt("prodOrderPoint"));
				prodOrderVO_getAll.setProdOrderReceiverName(rs.getString("prodOrderReceiverName"));
				prodOrderVO_getAll.setProdOrderReceiverTel(rs.getString("prodOrderReceiverTel"));
				prodOrderVO_getAll.setProdOrderReceiverMail(rs.getString("prodOrderReceiverMail"));
				prodOrderVO_getAll.setProdOrderReceiverAddress(rs.getString("prodOrderReceiverAddress"));
				prodOrderVO_getAll.setInvoiceNumber(rs.getString("invoiceNumber"));
				prodOrderVO_getAll.setTaxIDNumber(rs.getString("taxIDNumber"));
				prodOrderVO_list.add(prodOrderVO_getAll);
				
//				// 改建構子寫法。
//				Integer prodOrderNo = (rs.getInt("prodOrderNo"));
//				Integer memberNo = (rs.getInt("memberNo"));
//				Integer restaurantNo = (rs.getInt("restaurantNo"));
//				Integer couponNo = (rs.getInt("couponNo"));
//				String orderStatus = (rs.getString("orderStatus"));
//				java.sql.Timestamp prodOrderDate = (rs.getTimestamp("prodOrderDate"));
//				java.sql.Timestamp prodOrderReveiveTime = (rs.getTimestamp("prodOrderReveiveTime"));
//				java.sql.Timestamp prodOderDeliverTime = (rs.getTimestamp("prodOderDeliverTime"));
//				Integer deliverFee = (rs.getInt("deliverFee"));
//				Integer amountBeforeCoupon = (rs.getInt("amountBeforeCoupon"));
//				Integer amountAfterCoupon = (rs.getInt("amountAfterCoupon"));
//				Integer prodOrderPoint = (rs.getInt("prodOrderPoint"));
//				String prodOrderReceiverName = (rs.getString("prodOrderReceiverName"));
//				String prodOrderReceiverTel = (rs.getString("prodOrderReceiverTel"));
//				String prodOrderReceiverMail = (rs.getString("prodOrderReceiverMail"));
//				String prodOrderReceiverAddress = (rs.getString("prodOrderReceiverAddress"));
//				String invoiceNumber = (rs.getString("invoiceNumber"));
//				String taxIDNumber = (rs.getString("taxIDNumber"));
//				
//				ProdOrderVO prodOrderVO_getAll = new ProdOrderVO(prodOrderNo, memberNo, restaurantNo, couponNo, orderStatus, prodOrderDate, prodOrderReveiveTime, 
//						prodOderDeliverTime, deliverFee, amountBeforeCoupon, amountAfterCoupon, prodOrderPoint, prodOrderReceiverName, 
//						prodOrderReceiverTel, prodOrderReceiverMail, prodOrderReceiverAddress, invoiceNumber, taxIDNumber);
//				prodOrderVO_list.add(prodOrderVO_getAll);
				
			}
			
//			for (ProdOrderVO prodOrderVO_select1 : prodOrderVO_list) {
//				System.out.println(prodOrderVO_select1);
//			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return prodOrderVO_list;
	};
}
