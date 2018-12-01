package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Article;

import java.util.List;

public interface ShowArticleService {
    List<Article> showNotices();

    List<Article> showNews();
}
