package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    public ArticleRepository articleRepository;

    @GetMapping("/")
    public List<Article> index(@RequestParam(name = "cid") int cid) {
        return articleRepository.findAllByCategoryId(cid);
    }

    @GetMapping("/{id}")
    public Article show(@PathVariable(value = "id")int id) {
        return articleRepository.findById(id);
    }

    @PostMapping("/")
    public Article store(@RequestBody Article article) {
        // @RequestBody 需要使用 json
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable(value = "id")int id, @RequestBody Article article) {
        article.setId(id);

        return articleRepository.saveAndFlush(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        articleRepository.deleteById(id);
    }
}
