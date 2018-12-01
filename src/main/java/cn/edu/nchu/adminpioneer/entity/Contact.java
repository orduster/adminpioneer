package cn.edu.nchu.adminpioneer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Contact {
    private String address;//地址
    private String tele;//联系电话
    private String email;//邮箱
}
