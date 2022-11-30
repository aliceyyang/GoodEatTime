package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import product.vo.ProdCategoryVO;

public class ProdCategoryDAO_JNDI implements ProdCategoryDAO_Interface {
	private DataSource dataSource;

	public ProdCategoryDAO_JNDI() {
		dataSource = common.connection.ServiceLocator.getInstance().getDataSource();
	}

	@Override
	public void insert(ProdCategoryVO prodCategory) {
		String insertSQL = "insert into prodCategory (prodCategory) value(?);";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, prodCategory.getProdCategory());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProdCategoryVO prodCategory) {
		String updateSQL = "update prodCategory set prodCategory = ? where prodCategoryNo = ?;";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setString(1, prodCategory.getProdCategory());
			ps.setInt(2, prodCategory.getProdCategoryNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public boolean delete(Integer prodCategoryNo) {
		String deleteSQL = "delete from prodCategory where prodCategoryNo = ?";
		int rowCount = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, prodCategoryNo);
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public ProdCategoryVO findByPrimaryKey(Integer prodCategoryNo) {
		ProdCategoryVO myProdCategory = null;
		String findByPRimaryKeySQL = "select * from prodCategory where prodCategoryNo = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(findByPRimaryKeySQL)) {
			ps.setInt(1, prodCategoryNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myProdCategory = new ProdCategoryVO();
				myProdCategory.setProdCategoryNo(rs.getInt("prodCategoryNo"));
				myProdCategory.setProdCategory(rs.getString("prodCategory"));
			}
		} catch (SQLException e) {

		}
		return myProdCategory;
	}

	@Override
	public List<ProdCategoryVO> getAll() {
		ProdCategoryVO myProdCategory = null;
		List<ProdCategoryVO> list = new ArrayList<>();
		String getAllSQL = "select * from prodCategory";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(getAllSQL)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myProdCategory = new ProdCategoryVO();
				myProdCategory.setProdCategoryNo(rs.getInt("prodCategoryNo"));
				myProdCategory.setProdCategory(rs.getString("prodCategory"));
				list.add(myProdCategory);
			}
		} catch (SQLException e) {

		}
		return list;
	}

}
