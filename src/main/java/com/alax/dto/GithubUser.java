package com.alax.dto;

import lombok.Data;

/**
 * author: drew
 * date:2019/11/19
 * time:0:10
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
