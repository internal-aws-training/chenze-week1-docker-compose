package com.zac.dockerdemo.demo.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
//@Builder
@Data
@AllArgsConstructor
public class Article {

  public Article() {
  }

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  private String title;

  private String content;
}
