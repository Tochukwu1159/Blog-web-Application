package com.springboot.blog.payload;

import com.springboot.blog.entity.Post;
import lombok.Data;

@Data
public class PostDto{
    private long id;
    private String title;
    private String description;
    private String content;


}
