package com.example.studyblog.controller;

import com.example.studyblog.domain.Article;
import com.example.studyblog.dto.AddArticleRequest;
import com.example.studyblog.dto.ArticleResponse;
import com.example.studyblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){

        Article saveArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articleResponses = blogService.findAll().stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articleResponses);

    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

}


