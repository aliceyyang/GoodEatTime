package member.vo;
import java.util.Date;

public class Member {

 private Integer memberNo;
 private String memberLev;
 private String name;
 private Date birthday;
 private String mail;
 private String memberPassword;
 private Boolean verificationAccount;
 private String tel;
 private Integer point;
 private byte[] memberPic;
 public Integer getMemberNo() {
  return memberNo;
 }
 public void setMemberNo(Integer memberNo) {
  this.memberNo = memberNo;
 }
 public String getMemberLev() {
  return memberLev;
 }
 public void setMemberLev(String memberLev) {
  this.memberLev = memberLev;
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