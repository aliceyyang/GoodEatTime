package com.tibame.tga104.coupon.vo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "memberCoupon")
@IdClass(MemberCouponVO.PK.class)
public class MemberCouponVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "memberNo", nullable = false)
	private Integer memberNo;
	
	@Id
	@Column(name = "couponNo", nullable = false)
	private Integer couponNo;
	
	@Column(name = "usageStatus", columnDefinition = "Integer" , insertable = false)
	private Boolean usageStatus;

	public MemberCouponVO() {

	}

	@Override
	public String toString() {
		return "MemberCouponVO [memberNo=" + memberNo + ", couponNo=" + couponNo + ", usageStatus=" + usageStatus + "]";
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(Integer couponNo) {
		this.couponNo = couponNo;
	}

	public Boolean getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(Boolean usageStatus) {
		this.usageStatus = usageStatus;
	}

	static public class PK implements Serializable {
		public Integer memberNo;
		public Integer couponNo;
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			
			PK pk = (PK) obj;
			return Objects.equals(memberNo, pk.memberNo)
					&& Objects.equals(couponNo, pk.couponNo);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(memberNo, couponNo);
		}
	}
}
