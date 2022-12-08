package com.tibame.tga104.product.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodCategory")
public class ProdCategoryVO implements Serializable {

	private static final long serialVersionUID = 8634817940343444852L;
	@Id
	@Column(name = "prodCategoryNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer prodCategoryNo;
	@Column(name = "prodCategory")
	String prodCategory;

	public Integer getProdCategoryNo() {
		return prodCategoryNo;
	}

	public void setProdCategoryNo(Integer prodCategoryNo) {
		this.prodCategoryNo = prodCategoryNo;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	@Override
	public String toString() {
		return "prodCategoryVO [prodCategoryNo=" + prodCategoryNo + ", prodCategory=" + prodCategory + "]";
	}

}
