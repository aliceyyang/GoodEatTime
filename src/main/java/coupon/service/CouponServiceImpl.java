package coupon.service;

import java.util.List;

import coupon.dao.CouponDao;
import coupon.dao.impl.CouponDaoImpl;
import coupon.vo.CouponVO;

public class CouponServiceImpl implements CouponService{

	private CouponDao dao;
	
	public CouponServiceImpl() {
		dao = new CouponDaoImpl();
	}
	
	public CouponVO addCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail) {
		
		CouponVO couponVO = new CouponVO();
		
		couponVO.setRestaurantNo(restaurantNo);
		couponVO.setAdminNo(adminNo);
		couponVO.setCouponApplyDate(couponApplyDate);
		couponVO.setCouponName(couponName);
		couponVO.setCouponStartTime(couponStartTime);
		couponVO.setCouponEndTime(couponEndTime);
		couponVO.setVerified(verified);
		couponVO.setCouponContent(couponContent);
		couponVO.setUsageLimitation(usageLimitation);
		couponVO.setAmountOrFold(amountOrFole);
		couponVO.setMaxIssueQty(maxIssueQty);
		couponVO.setIssuedQty(issuedQty);
		couponVO.setVerificationDetail(verificationDetail);
		dao.insert(couponVO);
		
		return couponVO;
	}
	
	public CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail) {
				
		CouponVO couponVO = new CouponVO();
		couponVO.setRestaurantNo(restaurantNo);
		couponVO.setAdminNo(adminNo);
		couponVO.setCouponApplyDate(couponApplyDate);
		couponVO.setCouponName(couponName);
		couponVO.setCouponStartTime(couponStartTime);
		couponVO.setCouponEndTime(couponEndTime);
		couponVO.setVerified(verified);
		couponVO.setCouponContent(couponContent);
		couponVO.setUsageLimitation(usageLimitation);
		couponVO.setAmountOrFold(amountOrFole);
		couponVO.setMaxIssueQty(maxIssueQty);
		couponVO.setIssuedQty(issuedQty);
		couponVO.setVerificationDetail(verificationDetail);
		dao.update(couponVO);
		
		return couponVO;
		
	}
	
	public void deleteCoupon(Integer couponNo) {
		 dao.delete(couponNo);
		 
	}
	
	public CouponVO getOneCoupon(Integer couponNo) {
		return dao.findByPrimaryKey(couponNo);
	}
	
	public List<CouponVO> getAll() {
		return dao.getALL();
	}

	@Override
	public CouponVO updaCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName,
			String couponStartTime, String couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail) {
		// TODO Auto-generated method stub
		return null;
	}
}
