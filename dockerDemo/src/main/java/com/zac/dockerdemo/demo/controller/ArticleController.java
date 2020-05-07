package com.zac.dockerdemo.demo.controller;

import com.zac.dockerdemo.demo.domain.model.Article;
import com.zac.dockerdemo.demo.domain.model.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@CrossOrigin
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping
  public List<Article> all() {
    return articleService.getAllArticle();
  }

  @GetMapping("/fakes")
  public Article allFake() {
    List<Article> allFakeArticle = articleService.getAllFakeArticle();
    return allFakeArticle.get(0);
  }

  @GetMapping("/{id}")
  public Article allFake(@PathVariable Integer id) {
    return articleService.getById(id).orElse(null);
  }

  @GetMapping("hello")
  public String test() {
    return "hello world";
  }
}
