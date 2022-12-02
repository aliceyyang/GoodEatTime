package product.service;

import java.util.ArrayList;
import java.util.List;

import product.dao.ProdInfoDAO;
import product.dao.ProdInfoDAO_JDBC;
import product.vo.ProdInfoVO;

public class ProdInfoService {
	private ProdInfoDAO dao;
	
	public ProdInfoService() {
		dao = new ProdInfoDAO_JDBC();
	}
	
	public ProdInfoVO addProdInfo(Integer restaurantNo, Integer prodCategoryNo, String prodName,
			 Integer prodPrice, Integer prodStock, String prodDescription, String prodContent) {
		ProdInfoVO prodInfo = new ProdInfoVO();
		prodInfo.setRestaurantNo(restaurantNo);
		prodInfo.setProdCategoryNo(prodCategoryNo);
		prodInfo.setProdName(prodName);
		prodInfo.setProdPrice(prodPrice);
		prodInfo.setProdStock(prodStock);
		prodInfo.setProdDescription(prodDescription);
		prodInfo.setProdContent(prodContent);
		
		
		return dao.insert(prodInfo);
	}
	
	public ProdInfoVO updateProdInfo(Integer prodNo, Integer restaurantNo,
			Integer prodCategoryNo, String prodName, Integer prodPrice,
			Integer prodStock, String prodDescription, String prodContent,
			Integer prodCommentQty, Integer totalCommentRating) {
		ProdInfoVO prodInfo = new ProdInfoVO();
		prodInfo.setProdNo(prodNo);
		prodInfo.setRestaurantNo(restaurantNo);
		prodInfo.setProdCategoryNo(prodCategoryNo);
		prodInfo.setProdName(prodName);
		prodInfo.setProdPrice(prodPrice);
		prodInfo.setProdStock(prodStock);
		prodInfo.setProdDescription(prodDescription);
		prodInfo.setProdContent(prodContent);
		prodInfo.setProdCommentQty(prodCommentQty);
		prodInfo.setTotalCommentRating(totalCommentRating);
		
		dao.update(prodInfo);
		
		return prodInfo;
	}
	
	public boolean deleteProdInfo(Integer prodNo) {
		return dao.delete(prodNo);
	}
	
	public ProdInfoVO getOneProduct(Integer prodNo) {
		return dao.findByPrimaryKey(prodNo);
	}
	
	public List<ProdInfoVO> getAll() {
		return dao.getAll();
	}
	
	public List<ProdInfoVO> getByCategory(Integer prodCategoryNo) {
		return dao.findByProdCategory(prodCategoryNo);
	}
	
}
