package com.mikemcavoy.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.mikemcavoy.blog.tokenizer.Lexer;

@Component
public class ApplicationStartup implements CommandLineRunner {
    private final ResourceLoader resourceLoader;

    public ApplicationStartup(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:" + "data/posts/sample.md");
        Lexer lexer = new Lexer(resource.getInputStream());
        lexer.lex();
        lexer.logTokens();
    }

}
