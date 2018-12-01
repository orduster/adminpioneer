package cn.edu.nchu.adminpioneer.utils;

import cn.edu.nchu.adminpioneer.entity.File;

public class FileUtil {
    public File getFile(File file) {
        if (file.getSort().equals("1"))
            file.setSort("省部级政策");
        else if (file.getSort().equals("2"))
            file.setSort("校内文件");
        else if (file.getSort().equals("3"))
            file.setSort("资源下载");
        return file;
    }
}
