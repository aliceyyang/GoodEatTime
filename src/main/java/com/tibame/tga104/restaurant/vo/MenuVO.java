package com.tibame.tga104.restaurant.vo;

import java.io.Serializable;
import java.util.Arrays;

public class MenuVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer menuNo;
	private Integer restaurantNo;
	private byte[] menuPic;
	private String menuPicstr;
	private String menuPicRemark;
	
	public MenuVO() {
		
	}

	
	public MenuVO(Integer menuNo, Integer restaurantNo, byte[] menuPic, String menuPicstr, String menuPicRemark) {
		super();
		this.menuNo = menuNo;
		this.restaurantNo = restaurantNo;
		this.menuPic = menuPic;
		this.menuPicstr = menuPicstr;
		this.menuPicRemark = menuPicRemark;
	}




	public Integer getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(Integer menuNo) {
		this.menuNo = menuNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public byte[] getMenuPic() {
		return menuPic;
	}

	public void setMenuPic(byte[] menuPic) {
		this.menuPic = menuPic;
	}

	public String getMenuPicRemark() {
		return menuPicRemark;
	}

	public void setMenuPicRemark(String menuPicRemark) {
		this.menuPicRemark = menuPicRemark;
	}
	
	

	public String getMenuPicstr() {
		return menuPicstr;
	}



	public void setMenuPicstr(String menuPicstr) {
		this.menuPicstr = menuPicstr;
	}


	@Override
	public String toString() {
		return "MenuVO [menuNo=" + menuNo + ", restaurantNo=" + restaurantNo + ", menuPic=" + Arrays.toString(menuPic)
				+ ", menuPicstr=" + menuPicstr + ", menuPicRemark=" + menuPicRemark + "]";
	}



	
	
}
