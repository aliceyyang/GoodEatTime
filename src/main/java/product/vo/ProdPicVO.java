package product.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodPic")
public class ProdPicVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodPicNo", insertable = false)
	private Integer prodPicNo;
	@Column(name = "prodNo", nullable = false)
	private Integer prodNo;
	@Column(name = "prodPic", nullable = false, columnDefinition = "blob")
	private Byte[] prodPic;
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
	public Byte[] getProdPic() {
		return prodPic;
	}
	public void setProdPic(Byte[] prodPic) {
		this.prodPic = prodPic;
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
