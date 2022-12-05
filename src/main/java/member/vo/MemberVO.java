package member.vo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "member") // 資料庫名稱
public class MemberVO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberNo")
	private Integer memberNo;

	@Column(name = "memberLevel")
	private Integer memberLevel;

	@Column(name = "name")
	private String name;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "memberPassword")
	private String memberPassword;
	
	@Column(name = "verificationAccount")
	private Boolean verificationAccount;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "point")
	private Integer point;
	
	@Column(name = "memberPic", columnDefinition = "longblob")
	private byte[] memberPic;

	@Override
	public String toString() {
		return "memberBean [memberNo=" + memberNo + ", memberLevel=" + memberLevel + ", name=" + name + ", birthday="
				+ birthday + ", mail=" + mail + ", memberPassword=" + memberPassword + ", verificationAccount="
				+ verificationAccount + ", tel=" + tel + ", point=" + point + ", memberPic="
				+ Arrays.toString(memberPic) + "]";
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public Boolean getVerificationAccount() {
		return verificationAccount;
	}

	public void setVerificationAccount(Boolean verificationAccount) {
		this.verificationAccount = verificationAccount;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public byte[] getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(byte[] memberPic) {
		this.memberPic = memberPic;
	}

}