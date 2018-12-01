package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.IndexImages;

import java.util.List;

public interface IndexImagesService {
    List<IndexImages> showIndexImages(int pageSize, int pageNumber);

    int deleteById(int id);

    int count();

    int addIndexImages(IndexImages indexImages);

    int updateIndexImages(IndexImages indexImages);

    IndexImages getIndexImages(int id);

}
