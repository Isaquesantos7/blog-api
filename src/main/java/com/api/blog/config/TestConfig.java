package com.api.blog.config;

import com.api.blog.entities.Blog;
import com.api.blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void run(String... args) throws Exception {
        Blog blog1 = new Blog(null, "Ilay zum zum zum!", "Essa menina e doida!");
        Blog blog2 = new Blog(null, "Ilay zum zum zum!", "Essa menina tem problemas!");
        Blog blog3 = new Blog(null, "Ilay zum zum zum!", "Essa muitos problemas!");
        Blog blog4 = new Blog(null, "Ilay zum zum zum!", "E não gosta de estudar!");

        this.blogRepository.saveAll(Arrays.asList(blog1, blog2, blog3, blog4));
    }
}
