package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Article;
import cn.edu.nchu.adminpioneer.mapper.ShowArticleMapper;
import cn.edu.nchu.adminpioneer.service.ShowArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShowArticleServiceImpl implements ShowArticleService {

    @Autowired
    private ShowArticleMapper showArticleMapper;

    @Override
    public List<Article> showNotices() {
        return showArticleMapper.showNotices();
    }

    @Override
    public List<Article> showNews() {
        return showArticleMapper.showNews();
    }
}
