package cn.edu.nchu.adminpioneer.utils;

/**
 * 操作数据库工具类
 **/
public class SqlProviderUtil {
    //批量删除文章
    public String deleteArticleByIds(String ids) {
        return "delete from article where id in(" + ids + ")";
    }

    //批量删除团队资料
    public String deleteTeamByIds(String ids) {
        return "delete from team where id in(" + ids + ")";
    }

    //批量删除导师资料
    public String deleteTeacherByIds(String ids) {
        return "delete from teacher where id in(" + ids + ")";
    }

    /*批量删除作品*/
    public String deleteWorksByIds(String ids) {
        return "delete from works where id in(" + ids + ")";
    }

    /*批量删除文件*/
    public String deleteFilesByIds(String ids) {
        return "delete from file where id in(" + ids + ")";
    }

    /*批量删除标兵*/
    public String deleteEntrepreneurByIds(String ids) {
        return "delete from Entrepreneur where id in(" + ids + ")";
    }

    /*批量删除活动*/
    public String deleteActivityByIds(String ids) {
        return "delete from activity where id in(" + ids + ")";
    }
}
