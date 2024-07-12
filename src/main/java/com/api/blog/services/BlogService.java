package com.api.blog.services;

import com.api.blog.DTOS.BlogDTO;
import com.api.blog.entities.Blog;
import com.api.blog.repositories.BlogRepository;
import com.api.blog.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> listaTodosBlogs() {

        return this.blogRepository.findAll();
    }

    public Blog blogPorId(Integer id) {

        return this.blogRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não há nenhum objeto com esse ID!"));
    }

    public Blog saveBlog(Blog blog) {

        return this.blogRepository.save(blog);
    }

    public Blog deleteBlog(Integer id) {
        Blog blog = this.blogRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não há nenhum objeto com esse ID!"));

        this.blogRepository.deleteById(blog.getId());

        return blog;
    }

    public Blog update(Integer id, BlogDTO blogDTO) {
        Blog blog = this.blogRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não há nenhum objeto com esse ID!"));

        BeanUtils.copyProperties(blogDTO, blog, "id");

        return this.blogRepository.save(blog);
    }
}
