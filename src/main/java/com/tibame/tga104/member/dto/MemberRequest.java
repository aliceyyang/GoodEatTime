package com.tibame.tga104.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private Integer memberLevel;
    @NotNull
    private Boolean verificationAccount;
}
