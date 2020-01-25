package com.wzy.moviemark.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok("HelloWorld");
//        Response response = folderInteractor.getArticleList();
//        if (response.getCode() != 200) {
//            return HttpResponseHelper.respondRest(response);
//        }
//        return HttpResponseHelper.ok(response.getMessage());
    }
}
