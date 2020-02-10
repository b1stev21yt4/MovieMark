package com.wzy.moviemark.controller;

import com.wzy.moviemark.model.User;
import com.wzy.moviemark.service.UserService;
import com.wzy.moviemark.util.HttpResponseHelper;
import com.wzy.moviemark.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{page_num}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserLists(@PathVariable("page_num") int pageNum) {

        if (pageNum < 1 || pageNum > userService.getPageSize()) {
            return HttpResponseHelper.badRequest("Page number invalid.");
        }
        Response response = userService.getUserList(pageNum);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/user/{user_name}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("user_name") String userName) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = userService.getUser(userName);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = userService.createUser(user);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {

//        if (pageNum < 1 || pageNum > movieService.getPageSize()) {
//            return HttpResponseHelper.badRequest("Page number invalid.");
//        }

        Response response = userService.updateUser(updatedUser);

        if (response.getCode() != 200) {
            return HttpResponseHelper.respondRest(response);
        }
        return HttpResponseHelper.ok(response.getMessage());

    }


}
