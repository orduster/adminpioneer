package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Works;
import cn.edu.nchu.adminpioneer.mapper.WorksMapper;
import cn.edu.nchu.adminpioneer.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksMapper mapper;

    @Override
    public List<Works> getAllWorksLimit(int pageSize, int pageNumber) {
        return mapper.getAllWorksLimit(pageSize, pageNumber);
    }

    @Override
    public int addWorks(Works works) {
        return mapper.addWorks(works);
    }

    @Override
    public int deleteWorksById(Integer id) {
        return mapper.deleteWorksById(id);
    }

    @Override
    public int deleteWorksByIds(String ids) {
        return mapper.deleteWorksByIds(ids);
    }

    @Override
    public Works findWorksById(Integer id) {
        return mapper.findWorksById(id);
    }

    @Override
    public int updateWorksById(Works works) {
        return mapper.updateWorksById(works);
    }

    @Override
    public int countWorks() {
        return mapper.countWorks();
    }

}
