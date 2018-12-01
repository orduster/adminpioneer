package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Introduction;
import cn.edu.nchu.adminpioneer.mapper.IntroductionMapper;
import cn.edu.nchu.adminpioneer.service.IntroductionService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IntroductionServiceImpl implements IntroductionService {

    @Autowired
    private IntroductionMapper introductionMapper;

    @Override
    public Introduction getIntroduction() {
        return introductionMapper.getIntroduction();
    }

    @Override
    public int addIntr(Introduction introduction) {
        introduction.setTime(new TimeUtils().getNowTime());
        return introductionMapper.addIntr(introduction);
    }

    @Override
    public int updateIntr(Introduction introduction) {
        introduction.setTime(new TimeUtils().getNowTime());
        return introductionMapper.updateIntr(introduction);
    }
}
