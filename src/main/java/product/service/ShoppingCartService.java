package product.service;

import java.util.List;

import common.connection.HibernateUtil;
import product.dao.ShoppingCartDAO;
import product.dao.ShoppingCartDAO_Hibernate;
import product.vo.ShoppingCartVO;

public class ShoppingCartService {
	private ShoppingCartDAO dao;
	public ShoppingCartService() {
		dao = new ShoppingCartDAO_Hibernate(HibernateUtil.getSessionFactory());
	}
	
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO != null && shoppingCartVO.getMemberNo() != null
				&& shoppingCartVO.getProdNo() != null && shoppingCartVO.getProdQty() != null) {
			ShoppingCartVO temp = dao.findByPrimaryKey(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo());
			if (temp == null) {
				return dao.insert(shoppingCartVO);
			}
		}
		return null;
	}
	
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO != null && shoppingCartVO.getMemberNo() != null
				&& shoppingCartVO.getProdNo() != null && shoppingCartVO.getProdQty() != null) {
			ShoppingCartVO temp = dao.findByPrimaryKey(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo());
			if (temp != null) {
				return dao.update(shoppingCartVO);
			}
		}
		return null;
	}
	
	public boolean delete(Integer memberNo, Integer prodNo) {
		if (memberNo != null && prodNo != null) {
			ShoppingCartVO temp = dao.findByPrimaryKey(memberNo, prodNo);
			if (temp != null) {
				return dao.delete(memberNo, prodNo);
			}
		}
		return false;
	}
	
	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo) {
		if (memberNo != null && prodNo != null) {
			return dao.findByPrimaryKey(memberNo, prodNo);
		}
		return null;
	}
	
	public List<ShoppingCartVO> getAll() {
		return dao.getAll();
	}
	
	public List<ShoppingCartVO> findByMemberNo(Integer memberNo) {
		if (memberNo != null) {
			return dao.findByMemberNo(memberNo);
		}
		return null;
	}
}
