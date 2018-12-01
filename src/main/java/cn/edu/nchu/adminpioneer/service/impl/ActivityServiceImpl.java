package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Activity;
import cn.edu.nchu.adminpioneer.mapper.ActivityMapper;
import cn.edu.nchu.adminpioneer.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper mapper;

    @Override
    public List<Activity> showActivity(int pageSize, int pageNumber) {
        return mapper.showActivity(pageSize, pageNumber);
    }

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public int addActivity(Activity activity) {
        return mapper.addActivity(activity);
    }

    @Override
    public Activity getActivityById(int id) {
        return mapper.getActivityById(id);
    }

    @Override
    public int updateActivity(Activity activity) {
        return mapper.updateActivity(activity);
    }
}
