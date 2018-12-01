package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Works;

import java.util.List;

public interface WorksService {
    /*得到双创作品列表*/
    List<Works> getAllWorksLimit(int pageSize, int pageNumber);

    /*增加作品*/
    int addWorks(Works works);

    /*根据id来删除作品*/
    int deleteWorksById(Integer id);

    /*根据id批量删除作品*/
    int deleteWorksByIds(String ids);

    /*根据id来查找作品*/
    Works findWorksById(Integer id);

    /*更新*/
    int updateWorksById(Works works);

    /*统计总数*/
    int countWorks();

}
