package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.College;
import cn.edu.nchu.adminpioneer.mapper.CollegeMapper;
import cn.edu.nchu.adminpioneer.service.CollegeService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper mapper;

    @Override
    public College getCollege() {
        return mapper.getCollege();
    }

    @Override
    public int addCollege(College college) {
        college.setTime(new TimeUtils().getNowTime());
        return mapper.addCollege(college);
    }

    @Override
    public int updateCollege(College college) {
        college.setTime(new TimeUtils().getNowTime());
        return mapper.updateCollege(college);
    }
}
