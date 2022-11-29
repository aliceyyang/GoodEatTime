package order.vo;

public class ProdOrderDetailVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
		private Integer prodOrderNo;
		private Integer prodNo;
		private Integer prodQty;
		private Integer prodPrice;	
		private Integer prodCommentRating;
		private String prodCommentContent;	
		private byte[] prodCommentPic;
		private java.sql.Timestamp prodCommentTime;
		private java.sql.Timestamp restaurantReplyTime;
		
		public Integer getProdOrderNo() {
			return prodOrderNo;
		}
		public void setProdOrderNo(Integer prodOrderNo) {
			this.prodOrderNo = prodOrderNo;
		}
		public Integer getProdNo() {
			return prodNo;
		}
		public void setProdNo(Integer prodNo) {
			this.prodNo = prodNo;
		}
		public Integer getProdQty() {
			return prodQty;
		}
		public void setProdQty(Integer prodQty) {
			this.prodQty = prodQty;
		}
		public Integer getProdPrice() {
			return prodPrice;
		}
		public void setProdPrice(Integer prodPrice) {
			this.prodPrice = prodPrice;
		}
		public Integer getProdCommentRating() {
			return prodCommentRating;
		}
		public void setProdCommentRating(Integer prodCommentRating) {
			this.prodCommentRating = prodCommentRating;
		}
		public String getProdCommentContent() {
			return prodCommentContent;
		}
		public void setProdCommentContent(String prodCommentContent) {
			this.prodCommentContent = prodCommentContent;
		}
		public byte[] getProdCommentPic() {
			return prodCommentPic;
		}
		public void setProdCommentPic(byte[] prodCommentPic) {
			this.prodCommentPic = prodCommentPic;
		}
		public java.sql.Timestamp getProdCommentTime() {
			return prodCommentTime;
		}
		public void setProdCommentTime(java.sql.Timestamp prodCommentTime) {
			this.prodCommentTime = prodCommentTime;
		}
		public java.sql.Timestamp getRestaurantReplyTime() {
			return restaurantReplyTime;
		}
		public void setRestaurantReplyTime(java.sql.Timestamp restaurantReplyTime) {
			this.restaurantReplyTime = restaurantReplyTime;
		}

}

