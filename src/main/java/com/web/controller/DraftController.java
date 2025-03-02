package com.web.controller;

import com.web.domain.Article;
import com.web.domain.Draft;
import com.web.service.ArticleService;
import com.web.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/drafts")
public class DraftController {
    @Autowired
    ArticleService articleService;
    @Autowired
    DraftService draftService;

    @PostMapping("/{uid}")
    public Result save(@RequestBody Draft draft, @PathVariable Integer uid) {
        boolean flag = draftService.save(draft, uid);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, null, null);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Draft draft) {
        boolean flag = draftService.update(draft);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = draftService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, null, null);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Draft draft = draftService.getById(id);
        Integer code = draft != null ? Code.GET_OK : Code.GET_ERR;
        String msg = draft != null ? "" : "数据查询失败,请重试!";
        return new Result(code, draft, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Draft> draftList = draftService.getAll();
        boolean flag = draftList == null || draftList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, draftList, msg);
    }

    @GetMapping("/getByAuthor/{uid}")
    public Result getByAuthor(@PathVariable Integer uid) {
        List<Draft> draftList = draftService.getByAuthor(uid);
        boolean flag = draftList == null || draftList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, draftList, msg);
    }

    @PostMapping("/publish/{id}")
    public Result publish(@PathVariable Integer id) {
        boolean flag = draftService.publish(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, null, null);
    }

}
