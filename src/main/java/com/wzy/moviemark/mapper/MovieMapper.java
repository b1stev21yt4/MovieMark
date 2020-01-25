package com.wzy.moviemark.mapper;

import com.wzy.moviemark.model.Movie;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MovieMapper {
//    @Select(" select * from movie_movie ")
//    @Results({
//            @Result(property = "movieid", column = "movieid"),
//            @Result(property = "movieid", javaType = List.class, column = "movieid", many = @Many(select = "com.how2java.mapper.ProductMapper.listByCategory") )
//    })
//    public List<Movie> list();



    @Select("select * from movie_movie where movieid= #{movieid} ")
    public Movie get(String movieid);

    @Select(" select * from movie_movie ")
    public List<Movie> list();
}
