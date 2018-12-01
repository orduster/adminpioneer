package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Practice;

public interface PracticeService {
    Practice getPractice();

    int updatePractice(Practice practice);

    int addPractice(Practice practice);
}
