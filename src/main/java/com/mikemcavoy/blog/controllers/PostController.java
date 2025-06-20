package com.mikemcavoy.blog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikemcavoy.blog.domain.Post;
import com.mikemcavoy.blog.dto.PostDto;
import com.mikemcavoy.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> allPosts() {
        List<Post> postsResult = this.postService.findAll();
        List<PostDto> postsDto = postsResult.stream()
                .map(post -> PostDto.fromDomain(post))
                .collect(Collectors.toList());

        return new ResponseEntity<List<PostDto>>(postsDto, HttpStatus.OK);
    }
}
