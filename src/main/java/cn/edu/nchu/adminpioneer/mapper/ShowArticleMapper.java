package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShowArticleMapper {


    @Select("select id,title,time from article where sort='通知公告' order by time desc limit 0,5")
    List<Article> showNotices();

    @Select("select id,title,time from article where sort='新闻资讯' order by time desc limit 0,5")
    List<Article> showNews();
}
