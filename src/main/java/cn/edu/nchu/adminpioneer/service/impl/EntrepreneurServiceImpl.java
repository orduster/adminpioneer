package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Entrepreneur;
import cn.edu.nchu.adminpioneer.mapper.EntrepreneurMapper;
import cn.edu.nchu.adminpioneer.service.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntrepreneurServiceImpl implements EntrepreneurService {

    @Autowired
    private EntrepreneurMapper mapper;

    @Override
    public List<Entrepreneur> showEntrepreneur(int pageSize, int pageNumber) {
        return mapper.showEntrepreneur(pageSize, pageNumber);
    }

    @Override
    public int countEntrepreneur() {
        return mapper.countEntrepreneur();
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
    public int addEntrepreneur(Entrepreneur entrepreneur) {
        return mapper.addEntrepreneur(entrepreneur);
    }

    @Override
    public Entrepreneur getEntrepreneurById(int id) {
        return mapper.getEntrepreneurById(id);
    }

    @Override
    public int updateEntrepreneur(Entrepreneur entrepreneur) {
        return mapper.updateEntrepreneur(entrepreneur);
    }
}
