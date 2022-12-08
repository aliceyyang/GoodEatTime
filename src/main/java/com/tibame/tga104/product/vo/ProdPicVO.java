package com.tibame.tga104.product.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "prodPic")
public class ProdPicVO implements Serializable{
	private static final long serialVersionUID = -3072905813299511170L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodPicNo", insertable = false)
	private Integer prodPicNo;
	@Column(name = "prodNo", nullable = false)
	private Integer prodNo;
	@Column(name = "prodPic", nullable = false, columnDefinition = "longblob")
	private byte[] prodPic;
	@Column(name = "prodPicRemark")
	private String prodPicRemark;
	public Integer getProdPicNo() {
		return prodPicNo;
	}
	public void setProdPicNo(Integer prodPicNo) {
		this.prodPicNo = prodPicNo;
	}
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public byte[] getProdPic() {
		return prodPic;
	}
	public void setProdPic(byte[] bytes) {
		this.prodPic = bytes;
	}
	public String getProdPicRemark() {
		return prodPicRemark;
	}
	public void setProdPicRemark(String prodPicRemark) {
		this.prodPicRemark = prodPicRemark;
	}
	@Override
	public String toString() {
		return "ProdPicVO [prodPicNo=" + prodPicNo + ", prodNo=" + prodNo + ", prodPicRemark=" + prodPicRemark + "]";
	}
	
}
