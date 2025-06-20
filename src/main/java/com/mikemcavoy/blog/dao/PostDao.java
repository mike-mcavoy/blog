package com.mikemcavoy.blog.dao;

import java.util.List;

import com.mikemcavoy.blog.domain.Post;

public interface PostDao {
    void save(Post post);

    List<Post> find();
}
