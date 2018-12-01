package cn.edu.nchu.adminpioneer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化当前时间
 **/
public class TimeUtils {
    public String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }
}
