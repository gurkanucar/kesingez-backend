package com.gucarsoft.kesingez.controller;

import com.gucarsoft.kesingez.model.post.comment.Comment;
import com.gucarsoft.kesingez.model.post.Post;
import com.gucarsoft.kesingez.model.post.PostFilter;
import com.gucarsoft.kesingez.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @Autowired
    PostService postService;

    //@PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity getAllPosts(@RequestBody(required = false) PostFilter postFilter) {
        if(postFilter!=null){
            return postService.getAllFilteredPosts(postFilter);
        }
        return postService.getAllPosts();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/my")
    public ResponseEntity getMyPosts() {
        return postService.getMyPosts();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable Long id) {
        return postService.getpostByID(id);
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity create(@RequestBody Post entity) {
        return postService.createPost(entity);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public ResponseEntity update(@RequestBody Post entity) {
        return postService.updatePost(entity);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/report/{id}")
    public ResponseEntity reportPost(@PathVariable Long id) {
        return postService.reportPost(id);
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/comment/{id}")
    public ResponseEntity getComments(@PathVariable Long id) {
        return postService.getComments(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/comment")
    public ResponseEntity addComment(@RequestBody Comment comment) {
        return postService.addComment(comment);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        return postService.deleteComment(id);
    }

}
