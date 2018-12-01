package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Article;
import cn.edu.nchu.adminpioneer.service.ArticleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminpioneer/admin")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //进入文章
    @GetMapping(value = "/articleList")
    public String articles() {
        return "article";
    }

    //显示所有文章
    @PostMapping(value = "/articles", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> showArticle(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<Article> articles = articleService.showArticle(pageSize, offset);
        int count = articleService.countArticle();
        map.put("total", count);
        map.put("rows", articles);
        return map;
    }

    //来到员工添加页面
    @GetMapping("/article")
    public String toAddPage() {
        return "addArticle";
    }

    //添加一篇文章
    @PostMapping(value = "/article")
    public String addArticle(Article article) {
        articleService.addArticle(article);
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/articleList";
    }

    //来到修改页面
    @GetMapping("/article/{id}")
    public String toEditPage(@PathVariable("id") int id, Model model) {
        Article articleById = articleService.getArticleById(id);
        model.addAttribute("article", articleById);
        return "addArticle";
    }

    //提交修改
    @PutMapping("/article")
    public String updateArticle(Article article) {
        int i = articleService.updateArticle(article);
        return "redirect:/adminpioneer/admin/articleList";
    }

    //显示一篇文章
    @GetMapping("/showArticle/{id}")
    public String showArticleById(@PathVariable("id") int id, Model model) {
        Article articleById = articleService.showArticleById(id);
        model.addAttribute("article", articleById);
        return "articleDetails";
    }

    //删除一篇文章
    @PostMapping(value = "/articleList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int byId = articleService.deleteById(id);
        if (byId > 0) {
            map.put("msg", "成功删除文章");
        } else {
            map.put("msg", "删除文章失败");
        }
        return map;
    }

    //批量删除文章
    @PostMapping(value = "/articleList/deleteByIds", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestBody JSONObject jsonParam) {
        String ids = jsonParam.getString("ids");
        Map<String, Object> map = new HashMap<>();
        int byIds = articleService.deleteByIds(ids);
        if (byIds > 0) {
            map.put("msg", "批量删除文章成功！");
        } else {
            map.put("msg", "批量删除文章失败！");
        }
        return map;
    }
}
