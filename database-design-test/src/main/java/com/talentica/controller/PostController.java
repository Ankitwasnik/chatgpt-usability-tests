package com.talentica.controller;

import com.talentica.dto.PostDto;
import com.talentica.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping
  public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Long userId,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    Page<PostDto> posts = postService.getPostsByUser(userId, page, size);
    return ResponseEntity.ok(posts.getContent());
  }
}

