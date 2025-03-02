package com.web.service.impl;

import com.web.dao.ArticleDao;
import com.web.dao.DraftDao;
import com.web.domain.Article;
import com.web.domain.Draft;
import com.web.domain.User;
import com.web.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DraftServiceImpl implements DraftService {

    @Autowired
    DraftDao draftDao;
    @Autowired
    ArticleDao articleDao;

    @Override
    public boolean save(Draft draft,Integer uid) {
        return draftDao.saveDraft(draft)>0&&draftDao.saveDraft_user(uid)>0;
    }

    @Override
    public boolean update(Draft draft) {
        return draftDao.update(draft)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return draftDao.delete(id)>0;
    }

    @Override
    public Draft getById(Integer id) {
        return draftDao.getById(id);
    }

    @Override
    public List<Draft> getAll() {
        return draftDao.getAll();
    }

    @Override
    public List<Draft> getByAuthor(Integer uid) {
        return draftDao.getByAuthor(uid);
    }

    @Override
    public User getAuthor(Integer did) {
        return draftDao.getAuthor(did);
    }

    @Override
    public boolean publish(Integer id) {
        Draft draft=getById(id);
        Integer uid=getAuthor(id).getId();
        Article article=new Article(draft.getTitle(),draft.getContent(),0,0,draft.getCategory(), LocalDateTime.now());
        return articleDao.save(article)>0&&draftDao.publish(uid)>0;
    }
}
