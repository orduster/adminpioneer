package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IndexImages {
    private Integer id;
    private String description;
    private String url;

    public IndexImages() {
    }

    public IndexImages(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public IndexImages(Integer id, String description, String url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }
}
