package product.service;

import java.util.List;

import common.connection.HibernateUtil;
import product.dao.ProdPicDAO;
import product.dao.ProdPicDAO_Hibernate;
import product.vo.ProdPicVO;

public class ProdPicService {
	private ProdPicDAO dao;
	
	public ProdPicService() {
		dao = new ProdPicDAO_Hibernate(HibernateUtil.getSessionFactory());
	}
	
	public ProdPicVO addProdPic(Integer prodNo, byte[] pic, String prodPicRemark) {
		ProdPicVO prodPicVO = new ProdPicVO();
		prodPicVO.setProdNo(prodNo);
		prodPicVO.setProdPic(pic);
		prodPicVO.setProdPicRemark(prodPicRemark);
		
		return dao.insert(prodPicVO);
	}
	
	public ProdPicVO updateProdPic(Integer prodPicNo, Integer prodNo, byte[] pic, String prodPicRemark) {
		ProdPicVO prodPicVO = new ProdPicVO();
		prodPicVO.setProdPicNo(prodPicNo);
		prodPicVO.setProdNo(prodNo);
		prodPicVO.setProdPic(pic);
		prodPicVO.setProdPicRemark(prodPicRemark);
		
		return dao.update(prodPicVO);
	}
	
	public boolean deleteProdPic(Integer prodPicNo) {
		return dao.delete(prodPicNo);
	}
	
	public ProdPicVO getOneProdPic(Integer prodPicNo) {
		return dao.findByPrimaryKey(prodPicNo);
	}
	
	public List<ProdPicVO> getAll() {
		return dao.getAll();
	}
	
	public List<ProdPicVO> findByProdNo(Integer prodNo) {
		return dao.findByProdNo(prodNo);
	}
}
