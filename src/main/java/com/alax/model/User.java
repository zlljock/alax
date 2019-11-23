package com.alax.model;

import lombok.Data;

/**
 * author: drew
 * date:2019/11/19
 * time:23:59
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
