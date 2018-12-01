package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学院简介
 */
@Setter
@Getter
@ToString
public class College {
    private String content;//正文
    private String text;//html正文
    private String time;//时间
}
