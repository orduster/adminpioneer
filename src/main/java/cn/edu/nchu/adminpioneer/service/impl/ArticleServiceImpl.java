package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Article;
import cn.edu.nchu.adminpioneer.mapper.ArticleMapper;
import cn.edu.nchu.adminpioneer.service.ArticleService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> showArticle(int pageSize, int pageNumber) {
        return articleMapper.showArticle(pageSize, pageNumber);
    }

    @Override
    public int deleteById(int id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public int countArticle() {
        return articleMapper.countArticle();
    }

    @Override
    public int deleteByIds(String ids) {
        return articleMapper.deleteByIds(ids);
    }

    @Override
    public int addArticle(Article article) {
        article.setTime(new TimeUtils().getNowTime());
        return articleMapper.addArticle(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public int updateArticle(Article article) {
        article.setTime(new TimeUtils().getNowTime());
        return articleMapper.updateArticle(article);
    }

    @Override
    public Article showArticleById(int id) {
        return articleMapper.showArticleById(id);
    }

}
