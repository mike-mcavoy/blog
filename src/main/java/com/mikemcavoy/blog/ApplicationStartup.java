package com.mikemcavoy.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.mikemcavoy.blog.domain.Post;
import com.mikemcavoy.blog.generator.Generator;
import com.mikemcavoy.blog.generator.Generator.CompiledPost;
import com.mikemcavoy.blog.parser.Parser;
import com.mikemcavoy.blog.service.PostService;
import com.mikemcavoy.blog.tokenizer.Lexer;

@Component
public class ApplicationStartup implements CommandLineRunner {
    private final ResourceLoader resourceLoader;
    private final PostService postService;

    public ApplicationStartup(ResourceLoader resourceLoader, PostService postService) {
        this.resourceLoader = resourceLoader;
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:" + "data/posts/sample.md");

        Lexer lexer = new Lexer(resource.getInputStream());
        lexer.lex();
        var tokens = lexer.getTokens();

        Parser parser = new Parser(tokens);
        var tree = parser.parse();
        CompiledPost compiledPost = Generator.generateHtmlString(tree);

        Post post = Post.builder()
                .slug(compiledPost.slug())
                .created(compiledPost.created())
                .html(compiledPost.htmlString())
                .build();
        postService.create(post);
    }

}
