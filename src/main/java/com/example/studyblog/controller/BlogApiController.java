package com.example.studyblog.controller;

import com.example.studyblog.domain.Article;
import com.example.studyblog.dto.AddArticleRequest;
import com.example.studyblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){

        Article saveArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }

}


