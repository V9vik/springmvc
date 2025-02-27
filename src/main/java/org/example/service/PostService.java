package org.example.service;

import org.example.model.Post;
import org.example.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.example.NotFoundException;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        return post;
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}

