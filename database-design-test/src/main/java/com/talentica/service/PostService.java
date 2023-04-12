package com.talentica.service;

import com.talentica.dto.PostDto;
import com.talentica.mapper.PostMapper;
import com.talentica.model.Post;
import com.talentica.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostMapper postMapper;

  public Page<PostDto> getPostsByUser(Long userId, int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
    Page<Post> posts = postRepository.findByUserUserId(userId, pageable);
    return posts.map(postMapper::postToPostDto);
  }
}

