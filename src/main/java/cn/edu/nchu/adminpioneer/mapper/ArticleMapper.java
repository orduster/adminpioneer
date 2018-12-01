package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Article;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    /*得到列表*/
    @Select("select id,sort,title,author,time from article order by time desc limit #{pageNumber},#{pageSize}")
    List<Article> showArticle(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    /*根据id删除*/
    @Delete("delete from article where id = #{id}")
    int deleteById(@Param("id") int id);

    /*统计总数*/
    @Select("select count(*) from article")
    int countArticle();

    /*批量删除*/
    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteArticleByIds")
    int deleteByIds(String ids);

    /*增加*/
    @Insert("insert into article values(null,#{sort},#{title},#{author},#{from},#{time},#{content},#{text})")
    int addArticle(Article article);

    /*来到修改页面，先加载文章*/
    @Select("select id,title,author,`from`,content from article where id=#{id}")
    Article getArticleById(@Param("id") int id);

    /*更新*/
    @Update("update article set sort=#{sort},title=#{title},author=#{author},`from`=#{from},time=#{time},content=#{content},text=#{text} where id=#{id}")
    int updateArticle(Article article);

    /**/
    @Select("select id,title,author,'from',content,text from article where id=#{id}")
    Article showArticleById(@Param("id") int id);
}
