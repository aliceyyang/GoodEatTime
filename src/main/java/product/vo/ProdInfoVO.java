package product.vo;

public class ProdInfoVO implements java.io.Serializable{
	
	private static final long serialVersionUID = -8107177340605184651L;
	private Integer prodNo;
	private Integer restaurantNo;
	private Integer prodCategoryNo;
	private String prodName;
	private Integer prodPrice;
	private Integer prodStock;
	private String prodDescription;
	private String prodContent;
	private Integer prodCommentQty;
	private Integer totalCommentRating;
	
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public Integer getProdCategoryNo() {
		return prodCategoryNo;
	}
	public void setProdCategoryNo(Integer prodCategoryNo) {
		this.prodCategoryNo = prodCategoryNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Integer getProdStock() {
		return prodStock;
	}
	public void setProdStock(Integer prodStock) {
		this.prodStock = prodStock;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public Integer getProdCommentQty() {
		return prodCommentQty;
	}
	public void setProdCommentQty(Integer prodCommentQty) {
		this.prodCommentQty = prodCommentQty;
	}
	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}
	public void setTotalCommentRating(Integer prodCommentRating) {
		this.totalCommentRating = prodCommentRating;
	}
	@Override
	public String toString() {
		return "ProductVO [prodNo=" + prodNo + ", restaurantNo=" + restaurantNo + ", prodCategoryNo=" + prodCategoryNo
				+ ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodStock=" + prodStock
				+ ", prodDescription=" + prodDescription + ", prodContent=" + prodContent + ", prodCommentQty="
				+ prodCommentQty + ", prodCommentRating=" + totalCommentRating + "]";
	}
}
