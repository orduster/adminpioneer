package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.File;

import java.util.List;

public interface FileService {
    /*添加文件*/
    int addFile(File file);

    File getFile(int id);

    /*文件列表*/
    List<File> getAllFile(int pageSize, int pageNumber);

    /*删除一个文件*/
    int deleteFileById(int id);

    /*批量删除*/
    int deleteFilesByIds(String ids);

    /*统计总数*/
    int count();
}
