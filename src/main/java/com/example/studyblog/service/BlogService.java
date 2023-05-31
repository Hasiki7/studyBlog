package com.example.studyblog.service;

import com.example.studyblog.domain.Article;
import com.example.studyblog.dto.AddArticleRequest;
import com.example.studyblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());

    }
}
