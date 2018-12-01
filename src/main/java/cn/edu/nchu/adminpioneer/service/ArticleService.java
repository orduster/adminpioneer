package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> showArticle(int pageSize, int pageNumber);

    int deleteById(int id);

    int countArticle();

    int deleteByIds(String ids);

    int addArticle(Article article);

    Article getArticleById(int id);

    int updateArticle(Article article);

    Article showArticleById(int id);
}
