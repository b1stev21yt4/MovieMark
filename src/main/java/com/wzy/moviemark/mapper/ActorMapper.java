package com.wzy.moviemark.mapper;

import com.wzy.moviemark.model.Actor;
import com.wzy.moviemark.model.Movie;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActorMapper {

    @Select("select * from movie_actor where actorid= #{actorid} ")
    public Actor get(String actorid);


    @Select(" select * from movie_actor LIMIT #{pageCap} OFFSET #{offset}")
    public List<Actor> listPage(int pageCap, int offset);

    @Select("select count(*) from movie_actor ")
    public int getActorCount();

    @Select(" select * from movie_actor where actorid in (select actorid_id from movie_act where movieid_id = #{movieid_id}) ")
    public List<Actor> listMoiveActors(String movieid_id);
}
