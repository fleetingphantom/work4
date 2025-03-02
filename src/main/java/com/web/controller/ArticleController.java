package com.web.controller;


import com.web.domain.Article;
import com.web.domain.User;
import com.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping
    public Result save(@RequestBody Article article) {
        boolean flag = articleService.save(article);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, null, null);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article) {
        boolean flag = articleService.update(article);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }

    @PostMapping("/addView/{id}")
    public Result addView(@PathVariable Integer id) {
        boolean flag =articleService.addViews(id);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }

    @PostMapping("/addLikes/{id}")
    public Result addLikes(@PathVariable Integer id) {
        boolean flag =articleService.addLikes(id);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = articleService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, null, null);
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Integer id) {
        Article article = articleService.getById(id);
        Integer code = article != null ? Code.GET_OK : Code.GET_ERR;
        String msg = article != null ? "" : "数据查询失败,请重试!";
        return new Result(code,article, msg);
    }

    @GetMapping("/getByCategory/{category}")
    public Result getByCategory(@PathVariable String category) {
        List<Article> articleList= articleService.getByCategory(category);
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code,articleList, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Article> articleList = articleService.getAll();
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, articleList, msg);
    }

    @GetMapping("/orderByView")
    public Result orderByView() {
        List<Article> articleList = articleService.orderByView();
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, articleList, msg);
    }

    @GetMapping("/orderByLikes")
    public Result orderByLikes() {
        List<Article> articleList = articleService.orderByLikes();
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, articleList, msg);
    }

    @GetMapping("/orderByCreateTime")
    public Result orderByCreateTime() {
        List<Article> articleList = articleService.orderByCreateTime();
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, articleList, msg);
    }

    @GetMapping("/getAuthor/{aid}")
    public Result getAuthor(@PathVariable Integer aid) {
        User user=articleService.getAuthor(aid);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败,请重试!";
        return new Result(code,user,msg);
    }

    @GetMapping("/getByAuthor/{uid}")
    public Result getByAuthor(@PathVariable Integer uid) {
        List<Article> articleList=articleService.getByAuthor(uid);
        boolean flag = articleList == null || articleList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code,articleList,msg);
    }
}
