package com.web.service;

import com.web.domain.Draft;
import com.web.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DraftService {

    boolean  save(Draft draft,Integer uid);

    boolean update(Draft draft);

    boolean delete(Integer id);

    Draft getById(Integer id);

    List<Draft> getAll();

    List<Draft> getByAuthor(Integer uid);

    User getAuthor(Integer did);

    boolean publish(Integer id);
}
