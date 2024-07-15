package com.api.blog.controller;

import com.api.blog.DTOS.BlogDTO;
import com.api.blog.entities.Blog;
import com.api.blog.services.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Lista todas as noticias!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista das noticias cadastradas!"),
            }
    )
    @GetMapping("/api/blog")
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> list = this.blogService.listaTodosBlogs();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(description = "Listando noticia com base no id passado como parametro!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista noticia com base no Id passado!"),
                    @ApiResponse(responseCode = "404", description = "Não existe noticia cadastrada com esse Id!")
            }
    )
    @GetMapping("/api/blog/{id}")
    public ResponseEntity<Blog> findById(@PathVariable(value = "id") Integer id) {
        Blog blog = this.blogService.blogPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(blog);
    }

    @Operation
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Noticia cadastrada com sucesso!")
            }
    )
    @PostMapping("/api/blog")
    public ResponseEntity<Blog> save(@RequestBody @Valid BlogDTO blogDTO) {
        Blog blog = new Blog();

        BeanUtils.copyProperties(blogDTO, blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.blogService.saveBlog(blog));
    }

    @Operation
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Noticia deletada com sucesso!"),
                    @ApiResponse(responseCode = "404", description = "Noticia não encontrada com esse id!")
            }
    )
    @DeleteMapping("/api/blog/{id}")
    public ResponseEntity<Blog> delete(@PathVariable(value = "id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.blogService.deleteBlog(id));
    }

    @Operation
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Noticia atualizada com sucesso!"),
                    @ApiResponse(responseCode = "404", description = "Noticia não encontrada com esse id!")
            }
    )
    @PutMapping("/api/blog/{id}")
    public ResponseEntity<Blog> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid BlogDTO blogDTO) {
        Blog updateBlog = this.blogService.update(id, blogDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updateBlog);
    }
}
