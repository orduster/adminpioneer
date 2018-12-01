package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.User;
import cn.edu.nchu.adminpioneer.mapper.UserMapper;
import cn.edu.nchu.adminpioneer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public Boolean findByUsernameAndPassword(User user) {
        return mapper.findByUsernameAndPassword(user) != null;
    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }
}
