package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 团队实体
 */
@Setter
@Getter
@ToString
public class Team {
    private Integer id;//主键
    private String name;//团队名称
    private String introduction;//简介
    private String url;//保存的图片
    private String content;//正文
    private String text;//带html的详情

    public Team() {
    }


    public Team(String name, String introduction, String url, String content, String text) {
        this.name = name;
        this.introduction = introduction;
        this.url = url;
        this.content = content;
        this.text = text;
    }

    public Team(Integer id, String name, String introduction, String url, String content, String text) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.url = url;
        this.content = content;
        this.text = text;
    }
}
