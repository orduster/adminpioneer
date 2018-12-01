package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.File;
import cn.edu.nchu.adminpioneer.mapper.FileMapper;
import cn.edu.nchu.adminpioneer.service.FileService;
import cn.edu.nchu.adminpioneer.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper mapper;

    @Override
    public int addFile(File file) {
        return mapper.addFile(file);
    }

    @Override
    public File getFile(int id) {
        return new FileUtil().getFile(mapper.getFile(id));
    }

    @Override
    public List<File> getAllFile(int pageSize, int pageNumber) {
        List<File> allFile = mapper.getAllFile(pageSize, pageNumber);
        for (File file : allFile) {
            new FileUtil().getFile(file);
        }
        return allFile;
    }

    @Override
    public int deleteFileById(int id) {
        return mapper.deleteFileById(id);
    }

    @Override
    public int deleteFilesByIds(String ids) {
        return mapper.deleteFilesByIds(ids);
    }

    @Override
    public int count() {
        return mapper.count();
    }
}
