package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Teacher {
    private Integer id;//主键
    private String sort;//分类
    private String name;//姓名
    private String position;//职称
    private String description;//研究领域
}
