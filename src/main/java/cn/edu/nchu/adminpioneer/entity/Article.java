package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 文章实体
 **/
@Setter
@Getter
@ToString
public class Article {
    private Integer id;//主键
    private String sort;//分类
    private String title;//标题
    private String author;//作者
    private String from;//来源
    private String time;//发布时间
    private String content;//正文
    private String text;//带html5的正文
}
