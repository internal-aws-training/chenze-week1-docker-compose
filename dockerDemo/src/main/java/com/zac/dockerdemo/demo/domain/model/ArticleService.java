package com.zac.dockerdemo.demo.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleService {

  private final ArticleRepository articleRepository;

  public List<Article> getAllArticle() {
    return articleRepository.findAll();
  }

  public List<Article> getAllFakeArticle() {
    Article article = new Article(1, "fake content", "fake title");
    return Arrays.asList(article);
  }

  public Optional<Article> getById(Integer id) {
    Optional<Article> byId = articleRepository.findById(id);
    return byId;
  }
}
