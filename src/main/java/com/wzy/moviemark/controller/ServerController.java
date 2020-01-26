package com.wzy.moviemark.controller;

import com.wzy.moviemark.mapper.MovieMapper;
import com.wzy.moviemark.model.Movie;
import com.wzy.moviemark.service.ActorService;
import com.wzy.moviemark.service.MovieService;
import com.wzy.moviemark.util.HttpResponseHelper;
import com.wzy.moviemark.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/movies/{page_num}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieLists(@PathVariable("page_num") int pageNum) {

        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
            return HttpResponseHelper.badRequest("Page number invalid.");
        }
        Response response = movieService.getMovieList(pageNum);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/actors/{page_num}", method = RequestMethod.GET)
    public ResponseEntity<?> getActorLists(@PathVariable("page_num") int pageNum) {

        if (pageNum < 1 || pageNum > actorService.getPageSize()) {
            return HttpResponseHelper.badRequest("Page number invalid.");
        }
        Response response = actorService.getActorList(pageNum);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/movie/{movie_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovie(@PathVariable("movie_id") String movieId) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = movieService.getMovie(movieId);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/actor/{actor_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActor(@PathVariable("actor_id") String actorId) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = actorService.getActor(actorId);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/actorsbymovie/{movie_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieActors(@PathVariable("movie_id") String movieId) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = actorService.getMovieActors(movieId);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/moviesbyactor/{actor_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActorMovies(@PathVariable("actor_id") String actorId) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = movieService.getActorMovies(actorId);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }
}
