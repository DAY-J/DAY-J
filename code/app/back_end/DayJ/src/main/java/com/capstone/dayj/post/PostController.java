package com.capstone.dayj.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/app-user/{user_id}")
    public void createPost(@PathVariable int user_id, @Valid @RequestBody PostDto.Request dto) {
        postService.createPost(dto, user_id);
    }

    @GetMapping
    public List<PostDto.Response> readAllPost() {
        return postService.readAllPost();
    }

    @GetMapping("/{post_id}")
    public PostDto.Response readPostById(@PathVariable int post_id) {
        return postService.readPostById(post_id);
    }

    @GetMapping("tag/{post_tag}")
    public List<PostDto.Response> readPostByTag(@PathVariable String post_tag){
        return postService.readPostByTag(post_tag);
    }
    @PatchMapping("/{post_id}")
    public void patchPost(@PathVariable int post_id, @Valid @RequestBody PostDto.Request post) {
        postService.updatePost(post_id, post);
    }

    @DeleteMapping("/{post_id}")
    public void deletePostById(@PathVariable int post_id) {
        postService.deletePostById(post_id);
    }
}
