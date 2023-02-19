package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private  final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    @GetMapping("all")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return  new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> editPost(@PathVariable Long id, @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.editPost(postDto,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);

    }
}
