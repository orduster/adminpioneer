package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.User;

public interface UserService {
    Boolean findByUsernameAndPassword(User user);

    int updateUser(User user);
}
