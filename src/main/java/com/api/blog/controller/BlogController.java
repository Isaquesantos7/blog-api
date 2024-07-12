package com.api.blog.controller;

import com.api.blog.DTOS.BlogDTO;
import com.api.blog.entities.Blog;
import com.api.blog.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/api/blog")
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> list = this.blogService.listaTodosBlogs();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/blog/{id}")
    public ResponseEntity<Blog> findById(@PathVariable(value = "id") Integer id) {
        Blog blog = this.blogService.blogPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(blog);
    }

    @PostMapping("/api/blog")
    public ResponseEntity<Blog> save(@RequestBody @Valid BlogDTO blogDTO) {
        Blog blog = new Blog();

        BeanUtils.copyProperties(blogDTO, blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.blogService.saveBlog(blog));
    }

    @DeleteMapping("/api/blog/{id}")
    public ResponseEntity<Blog> delete(@PathVariable(value = "id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.blogService.deleteBlog(id));
    }

    @PutMapping("/api/blog/{id}")
    public ResponseEntity<Blog> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid BlogDTO blogDTO) {
        Blog updateBlog = this.blogService.update(id, blogDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updateBlog);
    }
}
