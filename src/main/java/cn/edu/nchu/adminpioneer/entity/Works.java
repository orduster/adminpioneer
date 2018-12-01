package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 双创作品
 */
@Setter
@Getter
@ToString
public class Works {
    private Integer id;//主键
    private String name;//名称
    private String member;//团队成员
    private String incident;//获奖情况
    private String url;//图片路径

    public Works() {
    }

    public Works(String name, String member, String incident, String url) {
        this.name = name;
        this.member = member;
        this.incident = incident;
        this.url = url;
    }

    public Works(Integer id, String name, String member, String incident, String url) {
        this.id = id;
        this.name = name;
        this.member = member;
        this.incident = incident;
        this.url = url;
    }
}
