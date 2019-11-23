package com.alax.model;


    import lombok.Data;

/**
 * author: drew
 * date:2019/11/21
 * time:19:02
 */
//发布功能
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;


}
