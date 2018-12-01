package cn.edu.nchu.adminpioneer.utils;

import java.util.UUID;

/**
 * 随机生成id
 **/
public final class UUidUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
