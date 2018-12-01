package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Introduction;

public interface IntroductionService {
    Introduction getIntroduction();

    int addIntr(Introduction introduction);

    int updateIntr(Introduction introduction);
}
