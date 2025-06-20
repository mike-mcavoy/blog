package com.mikemcavoy.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mikemcavoy.blog.dao.PostDao;
import com.mikemcavoy.blog.domain.Post;
import com.mikemcavoy.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void create(Post post) {
        postDao.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postDao.find();
    }

}
