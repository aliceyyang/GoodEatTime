package com.tibame.tga104.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
@Table(name = "adOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adOrderNo")
    private Integer adOrderNo;
    @Column(name = "restaurantNo")
    private Integer restaurantNo;
    @Column(name = "adminNo")
    private Integer adminNo;

    @Column(name = "adOrderTime", insertable = false, updatable = false)
    private Date adOrderTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "adStartTime")
    private Date adStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "adEndTime")
    private Date adEndTime;
    @Column(name = "verified")
    private Boolean verified;
    @Column(name = "verificationDetail")
    private String verificationDetail;
    @NotNull
    @Column(name = "adOrderPrice")
    private Integer adOrderPrice;
    @Column(name = "slideshowPic", columnDefinition = "longblob", nullable = true)
    private byte[] slideshowPic;
//    @Transient
//    private String slideshowPicStr;
}
