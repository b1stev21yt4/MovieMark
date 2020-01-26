package com.wzy.moviemark.service;

import com.google.gson.Gson;
import com.wzy.moviemark.mapper.ActorMapper;
import com.wzy.moviemark.mapper.MovieMapper;
import com.wzy.moviemark.model.Actor;
import com.wzy.moviemark.model.Movie;
import com.wzy.moviemark.util.Response;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorService {
    private final ActorMapper actorMapper;
    final static Integer PAGE_CAPACITY = 25;

    public ActorService(ActorMapper actorMapper){
        this.actorMapper = actorMapper;
    }

    public Response getActorList(int pageNum){
        int offset = (pageNum - 1) * PAGE_CAPACITY;
        List<Actor> actorList = null;
        try {
            actorList = actorMapper.listPage(PAGE_CAPACITY, offset);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(actorList);
        return new Response(200, jsonResponse);
    }

    public int getPageSize(){
        int actorCount =  actorMapper.getActorCount();
        int pageCount = actorCount / PAGE_CAPACITY;
        return (actorCount % PAGE_CAPACITY == 0) ? pageCount : pageCount + 1;
    }

    public Response getActor(String actorId){
        Actor actor = null;
        try {
            actor = actorMapper.get(actorId);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(actor);
        return new Response(200, jsonResponse);
    }


    public Response getMovieActors(String movieId){
        List<Actor> movieActors = null;
        try {
            movieActors = actorMapper.listMoiveActors(movieId);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(movieActors);
//        System.out.println(movieMapper.getPageSize());
        return new Response(200, jsonResponse);
    }
}
