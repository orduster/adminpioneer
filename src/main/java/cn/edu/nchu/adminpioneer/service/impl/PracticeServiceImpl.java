package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Practice;
import cn.edu.nchu.adminpioneer.mapper.PracticeMapper;
import cn.edu.nchu.adminpioneer.service.PracticeService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private PracticeMapper practiceMapper;

    @Override
    public Practice getPractice() {
        return practiceMapper.getPractice();
    }

    @Override
    public int updatePractice(Practice practice) {
        practice.setTime(new TimeUtils().getNowTime());
        return practiceMapper.updatePractice(practice);
    }

    @Override
    public int addPractice(Practice practice) {
        practice.setTime(new TimeUtils().getNowTime());
        return practiceMapper.addPractice(practice);
    }
}
