package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 文件上传下载
 */
@Setter
@Getter
@ToString
public class File {
    private Integer id;
    private String sort;//分类
    private String name;//文件名
    private String url;//存储路径

    public File() {
    }

    public File(String sort, String name, String url) {
        this.sort = sort;
        this.name = name;
        this.url = url;
    }
}
