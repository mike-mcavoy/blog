package com.mikemcavoy.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mikemcavoy.blog.dao.PostDao;
import com.mikemcavoy.blog.domain.Post;

@Component
public class PostDaoImpl implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Post post) {
        jdbcTemplate.update(
                "INSERT INTO posts (slug, created_at, html) VALUES (?, ?, ?)",
                post.getSlug(),
                post.getCreated(),
                post.getHtml());
    }

    @Override
    public List<Post> find() {
        return jdbcTemplate.query(
                "SELECT slug, created_at, html FROM posts",
                new AuthorRowMapper());
    }

    public class AuthorRowMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Post.builder()
                    .slug(rs.getString("slug"))
                    .created(rs.getString("created_at"))
                    .html(rs.getString("html"))
                    .build();
        }
    }

}
