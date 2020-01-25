package com.wzy.moviemark.controller;

import com.wzy.moviemark.mapper.MovieMapper;
import com.wzy.moviemark.model.Movie;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private MovieMapper movieMapper;


//    public ServerController() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();

//        movieMapper = session.getMapper(MovieMapper.class);
//    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTest() throws IOException {

        List<Movie> movieList = movieMapper.list();


//        session.commit();
//        session.close();
        return ResponseEntity.ok(movieList);
//        Response response = folderInteractor.getArticleList();
//        if (response.getCode() != 200) {
//            return HttpResponseHelper.respondRest(response);
//        }
//        return HttpResponseHelper.ok(response.getMessage());
    }
}
