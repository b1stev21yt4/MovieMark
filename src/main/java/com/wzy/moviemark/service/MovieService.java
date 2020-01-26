package com.wzy.moviemark.service;

import com.google.gson.Gson;
import com.wzy.moviemark.mapper.MovieMapper;
import com.wzy.moviemark.model.Actor;
import com.wzy.moviemark.model.Movie;
import com.wzy.moviemark.util.Response;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MovieService {

    private final MovieMapper movieMapper;
    final static Integer PAGE_CAPACITY = 25;


    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public Response getMovieList(int pageNum){
        int offset = (pageNum - 1) * PAGE_CAPACITY;
        List<Movie> movieList = null;
        try {
            movieList = movieMapper.listPage(PAGE_CAPACITY, offset);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(movieList);
//        System.out.println(movieMapper.getPageSize());
        return new Response(200, jsonResponse);
    }

    public int getPageSize(){
        int movieCount =  movieMapper.getMovieCount();
        int pageCount = movieCount / PAGE_CAPACITY;
        return (movieCount % PAGE_CAPACITY == 0) ? pageCount : pageCount + 1;
    }

    public Response getMovie(String movieId){
        Movie movie = null;
        try {
            movie = movieMapper.get(movieId);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(movie);
        return new Response(200, jsonResponse);
    }


    public Response getActorMovies(String actorId) {
        List<Movie> actorMovies = null;
        try {
            actorMovies = movieMapper.listActorMovies(actorId);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(actorMovies);
//        System.out.println(movieMapper.getPageSize());
        return new Response(200, jsonResponse);
    }
}
