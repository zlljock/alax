package com.alax.dto;

import lombok.Data;

/**
 * author: drew
 * date:2019/11/18
 * time:23:29
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;




}
