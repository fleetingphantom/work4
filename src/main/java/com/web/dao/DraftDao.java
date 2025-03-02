package com.web.dao;

import com.web.domain.Article;
import com.web.domain.Draft;
import com.web.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DraftDao {
    @Insert("insert into drafts (title,content,category)" +
            "values(#{title},#{content},#{category})")
    int saveDraft(Draft draft);
    @Insert("insert into drafts_users (uid)" +
            "values(#{uid})")
    int saveDraft_user(Integer uid);

    @Insert("insert into articles_users (uid)" +
            "values(#{uid})")
    int publish(Integer uid);

    @Update("update drafts set title=#{title},content=#{content},category=#{category} where id = #{id}")
    int update(Draft draft);

    @Delete("delete from drafts where id = #{id} "+
            "delete from drafts_users where did = #{id}")
    int delete(Integer id);

    @Select("select * from drafts where id = #{id}")
    Draft getById(Integer id);

    @Select("select * from drafts")
    List<Draft> getAll();

    @Select("select d.* from drafts d inner join drafts_users du on d.id = du.did where du.uid=#{uid}")
    List<Draft> getByAuthor(Integer uid);

    @Select("select u.* from users u inner join drafts_users du on u.id = du.uid where du.did = #{did}")
    User getAuthor(Integer did);

}
