package com.tibame.tga104.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "administrator")
@NoArgsConstructor
@AllArgsConstructor
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

}
