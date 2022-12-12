package com.tibame.tga104.order.vo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
@Table(name = "adOrder")
public class AdOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adOrderNo")
    @NotNull
    private Integer adOrderNo;
    @NotNull
    @Column(name = "restaurantNo")
    private Integer restaurantNo;
    @Column(name = "adminNo")
    private Integer adminNo;
    @NotNull
    @Column(name = "adOrderTime", insertable = false, updatable = false)
    private Date adOrderTime;
    @NotNull
    @Column(name = "adStartTime")
    private Date adStartTime;
    @NotNull
    @Column(name = "adEndTime")
    private Date adEndTime;
    @Column(name = "verified")
    private Boolean verified;
    @Column(name = "verificationDetail")
    private String verificationDetail;
    @NotNull
    @Column(name = "adOrderPrice")
    private Integer adOrderPrice;
    @Column(name = "slideshowPic", columnDefinition = "longblob")
    private byte[] slideshowPic;
    //type unsure


    public AdOrder() {
    }

    @Override
    public String toString() {
        return "AdOrderVO{" +
                "adOrderNo=" + adOrderNo +
                ", restaurantNo=" + restaurantNo +
                ", adminNo=" + adminNo +
                ", adOrderTime=" + adOrderTime +
                ", adStartTime=" + adStartTime +
                ", adEndTime=" + adEndTime +
                ", verified=" + verified +
                ", verificationDetail='" + verificationDetail + '\'' +
                ", adOrderPrice=" + adOrderPrice +
                ", slideshowPic=" + slideshowPic +
                '}';
    }

    public Integer getAdOrderNo() {
        return adOrderNo;
    }

    public void setAdOrderNo(Integer adOrderNo) {
        this.adOrderNo = adOrderNo;
    }

    public Integer getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(Integer restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Date getAdOrderTime() {
        return adOrderTime;
    }

    public void setAdOrderTime(Date adOrderTime) {
        this.adOrderTime = adOrderTime;
    }

    public Date getAdStartTime() {
        return adStartTime;
    }

    public void setAdStartTime(Date adStartTime) {
        this.adStartTime = adStartTime;
    }

    public Date getAdEndTime() {
        return adEndTime;
    }

    public void setAdEndTime(Date adEndTime) {
        this.adEndTime = adEndTime;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getVerificationDetail() {
        return verificationDetail;
    }

    public void setVerificationDetail(String verificationDetail) {
        this.verificationDetail = verificationDetail;
    }

    public Integer getAdOrderPrice() {
        return adOrderPrice;
    }

    public void setAdOrderPrice(Integer adOrderPrice) {
        this.adOrderPrice = adOrderPrice;
    }

    public byte[] getSlideshowPic() {
        return slideshowPic;
    }

    public void setSlideshowPic(byte[] slideshowPic) {
        this.slideshowPic = slideshowPic;
    }
}
