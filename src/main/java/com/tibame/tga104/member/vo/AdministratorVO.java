package com.tibame.tga104.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Entity
@Table(name = "administrator")
//@NoArgsConstructor
//@AllArgsConstructor
public class AdministratorVO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminNo")
    private Integer adminNo;
    @Column(name = "adminAccount")
    private String adminAccount;
    @Column(name = "adminPassword")
    private String adminPassword;
    @Column(name = "adminName")
    private String adminName;
    @Column(name = "modifyAdminData")
    private Boolean modifyAdminData;
    @Column(name = "modifyMemberData")
    private Boolean modifyMemberData;
    @Column(name = "verifyRestaurant")
    private Boolean verifyRestaurant;
    @Column(name = "verifyAdCoupon")
    private Boolean verifyAdCoupon;

    public AdministratorVO() {
    }

    public AdministratorVO(Integer adminNo, String adminAccount, String adminPassword, String adminName, Boolean modifyAdminData, Boolean modifyMemberData, Boolean verifyRestaurant, Boolean verifyAdCoupon) {
        this.adminNo = adminNo;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.modifyAdminData = modifyAdminData;
        this.modifyMemberData = modifyMemberData;
        this.verifyRestaurant = verifyRestaurant;
        this.verifyAdCoupon = verifyAdCoupon;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Boolean getModifyAdminData() {
        return modifyAdminData;
    }

    public void setModifyAdminData(Boolean modifyAdminData) {
        this.modifyAdminData = modifyAdminData;
    }

    public Boolean getModifyMemberData() {
        return modifyMemberData;
    }

    public void setModifyMemberData(Boolean modifyMemberData) {
        this.modifyMemberData = modifyMemberData;
    }

    public Boolean getVerifyRestaurant() {
        return verifyRestaurant;
    }

    public void setVerifyRestaurant(Boolean verifyRestaurant) {
        this.verifyRestaurant = verifyRestaurant;
    }

    public Boolean getVerifyAdCoupon() {
        return verifyAdCoupon;
    }

    public void setVerifyAdCoupon(Boolean verifyAdCoupon) {
        this.verifyAdCoupon = verifyAdCoupon;
    }
}
