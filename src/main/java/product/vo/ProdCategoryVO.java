package product.vo;

import java.io.Serializable;

public class ProdCategoryVO implements Serializable {

	private static final long serialVersionUID = 8634817940343444852L;
	Integer prodCategoryNo;
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
