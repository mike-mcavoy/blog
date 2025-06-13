package com.mikemcavoy.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mikemcavoy.blog.services.FileLoader;

@Component
public class ApplicationStartup implements CommandLineRunner {
    private final FileLoader fileLoader;

    public ApplicationStartup(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        String contents = fileLoader.load("data/posts/sample.md");
        System.out.println(contents);
    }

}
