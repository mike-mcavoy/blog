package com.mikemcavoy.blog.service;

import java.util.List;

import com.mikemcavoy.blog.domain.Post;

public interface PostService {
    void create(Post post);

    List<Post> findAll();
}
