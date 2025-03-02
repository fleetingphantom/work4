package com.web.dao;


import com.web.domain.Article;
import com.web.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Insert("insert into articles (title,content,view,likes,category,createTime) " +
            "values(#{title},#{content},#{view},#{likes},#{category},#{createTime})")
    int save(Article article);

    @Update("update articles set title=#{title},content=#{content},category=#{category} where id = #{id}")
    int update(Article article);

    @Update("update articles set likes=likes+1 where id = #{id}")
    int addLikes(Integer id);

    @Update("update articles set view=view+1 where id = #{id}")
    int addViews(Integer id);

    @Delete("delete from articles where id = #{id} "+
            "delete from articles_users where aid = #{aid}")
    int delete(Integer id);

    @Select("select * from articles where id = #{id}")
    Article getById(Integer id);

    @Select("select * from articles where category = #{category}")
    List<Article> getByCategory(String category);

    @Select("select * from articles")
    List<Article> getAll();

    @Select("select * from articles order by view DESC")
    List<Article> orderByView();

    @Select("select * from articles order by likes DESC")
    List<Article> orderByLikes();

    @Select("select * from articles order by createTime DESC")
    List<Article> orderByCreateTime();

    @Select("select u.* from users u inner join articles_users au on u.id = au.uid where au.aid = #{aid}")
    User getAuthor(Integer aid);

    @Select("select a.* from articles a inner join articles_users au on  a.id = au.aid where au.uid = #{uid}")
    List<Article> getByAuthor(Integer uid);
}
