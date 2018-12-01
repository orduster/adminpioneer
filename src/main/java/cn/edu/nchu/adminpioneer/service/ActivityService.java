package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> showActivity(int pageSize, int pageNumber);

    int count();

    int deleteById(int id);

    int deleteByIds(String ids);

    int addActivity(Activity activity);

    Activity getActivityById(int id);

    int updateActivity(Activity activity);
}
