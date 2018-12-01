package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Entrepreneur;

import java.util.List;

public interface EntrepreneurService {
    List<Entrepreneur> showEntrepreneur(int pageSize, int pageNumber);

    int countEntrepreneur();

    int deleteById(int id);

    int deleteByIds(String ids);

    int addEntrepreneur(Entrepreneur entrepreneur);

    Entrepreneur getEntrepreneurById(int id);

    int updateEntrepreneur(Entrepreneur entrepreneur);
}
