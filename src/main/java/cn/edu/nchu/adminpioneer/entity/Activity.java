package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Activity {
    private Integer id;
    private String name;//名称
    private String introduction;//简介
    private String url;//保存的图片
    private String content;//正文
    private String text;

    public Activity() {
    }

    public Activity(String name, String introduction, String url, String content, String text) {
        this.name = name;
        this.introduction = introduction;
        this.url = url;
        this.content = content;
        this.text = text;
    }

    public Activity(Integer id, String name, String introduction, String url, String content, String text) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.url = url;
        this.content = content;
        this.text = text;
    }
}
