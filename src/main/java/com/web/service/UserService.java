package com.web.service;


import com.web.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {

    boolean save(User user);

    boolean updateName(Integer id,String name);

    boolean updatePwd(Integer id,String pwd);

    boolean delete(Integer id);

    User getById(Integer id);

    public List<User> getAll();

    public String login(String name,String pwd);

}
