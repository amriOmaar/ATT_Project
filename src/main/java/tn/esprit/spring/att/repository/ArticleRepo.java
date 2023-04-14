package tn.esprit.spring.att.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.att.entities.Article;

public interface ArticleRepo  extends JpaRepository<Article, Long> {


}
