package reservation.vo;

import java.io.Serializable;

public class ReserveTimeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer reserveTimeNo;
	private Integer restaurantNo;
	private String reserveTime;
	private Integer weekDay;
	private Integer allowReserveNum;

	public ReserveTimeVO(Integer reserveTimeNo, Integer restaurantNo, String reserveTime, Integer weekDay,
			Integer allowReserveNum) {
		super();
		this.reserveTimeNo = reserveTimeNo;
		this.restaurantNo = restaurantNo;
		this.reserveTime = reserveTime;
		this.weekDay = weekDay;
		this.allowReserveNum = allowReserveNum;
	}

	public ReserveTimeVO() {

	}

	@Override
	public String toString() {
		return "ReserveTimeVO [reserveTimeNo=" + reserveTimeNo + ", restaurantNo=" + restaurantNo + ", reserveTime="
				+ reserveTime + ", weekDay=" + weekDay + ", allowReserveNum=" + allowReserveNum + "]";
	}

	public Integer getReserveTimeNo() {
		return reserveTimeNo;
	}

	public void setReserveTimeNo(Integer reserveTimeNo) {
		this.reserveTimeNo = reserveTimeNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Integer getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}

	public Integer getAllowReserveNum() {
		return allowReserveNum;
	}

	public void setAllowReserveNum(Integer allowReserveNum) {
		this.allowReserveNum = allowReserveNum;
	}

}
