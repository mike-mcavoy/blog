package com.mikemcavoy.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @GetMapping()
    public String allPosts() {
        return "posts";
    }
}
