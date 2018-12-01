package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.IndexImages;
import cn.edu.nchu.adminpioneer.mapper.IndexImagesMapper;
import cn.edu.nchu.adminpioneer.service.IndexImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IndexImagesServiceImpl implements IndexImagesService {

    @Autowired
    private IndexImagesMapper mapper;

    @Override
    public List<IndexImages> showIndexImages(int pageSize, int pageNumber) {
        return mapper.showIndexImages(pageSize, pageNumber);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public int addIndexImages(IndexImages indexImages) {
        return mapper.addIndexImages(indexImages);
    }

    @Override
    public int updateIndexImages(IndexImages indexImages) {
        return mapper.updateIndexImages(indexImages);
    }

    @Override
    public IndexImages getIndexImages(int id) {
        return mapper.getIndexImages(id);
    }

}
