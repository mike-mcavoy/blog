package com.mikemcavoy.blog.dto;

import com.mikemcavoy.blog.domain.Post;

public record PostDto(String slug, String created, String html) {
    public Post toDomain() {
        return Post.builder()
                .slug(this.slug)
                .created(this.created)
                .html(this.html)
                .build();
    }

    public static PostDto fromDomain(Post post) {
        return new PostDto(post.getSlug(), post.getCreated(), post.getHtml());
    }
}
