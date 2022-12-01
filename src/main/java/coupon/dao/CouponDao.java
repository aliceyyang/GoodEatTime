package coupon.dao;

import java.util.*;

import coupon.vo.CouponVO;

public interface CouponDao {

	public void insert(CouponVO couponVO);
	
	public void update(CouponVO couponVO);

	public void delete(Integer couponNo);
	
	public CouponVO findByPrimaryKey(Integer CouponVO);
	
	public List<CouponVO> getAll();

}
