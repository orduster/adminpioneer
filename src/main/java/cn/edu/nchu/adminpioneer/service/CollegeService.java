package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.College;

public interface CollegeService {
    College getCollege();

    int addCollege(College college);

    int updateCollege(College college);
}
