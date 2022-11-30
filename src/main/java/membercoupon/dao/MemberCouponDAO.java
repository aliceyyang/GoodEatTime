package membercoupon.dao;

import java.util.List;

import membercoupon.vo.MemberCouponVO;

public interface MemberCouponDAO{

	public void insert(MemberCouponVO membercouponVO);
	
	public void update(MemberCouponVO membercoponVO);
	
	public void delete(Integer memberNo);
	
	public MemberCouponVO findByPrimaryKey(Integer memberNo);
	
	public List<MemberCouponVO> getAll();
}
