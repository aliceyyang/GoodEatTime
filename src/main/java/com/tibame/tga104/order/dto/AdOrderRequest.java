package com.tibame.tga104.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdOrderRequest {

//    @NotNull
    private Integer restaurantNo;
    private Integer adminNo;
//    @NotNull
    private Date adStartTime;
//    @NotNull
    private Date adEndTime;
    private Boolean verified;
    private String verificationDetail;
    @NotNull
    private Integer adOrderPrice;
    private byte[] slideshowPic;
    private ArrayList<String> slideshowPicBase64;
}
