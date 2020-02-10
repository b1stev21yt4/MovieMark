package com.wzy.moviemark.service;

import com.google.gson.Gson;
import com.wzy.moviemark.mapper.UserMapper;
import com.wzy.moviemark.model.User;
import com.wzy.moviemark.util.Response;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserMapper userMapper;
    final static Integer PAGE_CAPACITY = 25;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public Response getUserList(int pageNum){
        int offset = (pageNum - 1) * PAGE_CAPACITY;
        List<User> userList = null;
        try {
            userList = userMapper.listPage(PAGE_CAPACITY, offset);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(userList);
        return new Response(200, jsonResponse);
    }

    public int getPageSize(){
        int userCount =  userMapper.getUserCount();
        int pageCount = userCount / PAGE_CAPACITY;
        return (userCount % PAGE_CAPACITY == 0) ? pageCount : pageCount + 1;
    }

    public Response getUser(String userName){
        User user = null;
        try {
            user = userMapper.get(userName);
        } catch (Exception e){
            System.out.println(e);
            return new Response(500, e.getMessage());
        }
        String jsonResponse = new Gson().toJson(user);
        return new Response(200, jsonResponse);
    }

    public Response createUser(User user){
        try {
            userMapper.create(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new Response(500, e.getMessage());
        }

        String jsonResponse = new Gson().toJson(user);
        return new Response(200, jsonResponse);

    }

    public Response updateUser(User updatedUser){
        User preUser = null;
        try {
            preUser = userMapper.get(updatedUser.getUserName());
        }   catch (Exception e){
            System.out.println(e.getMessage());
            return new Response(500, e.getMessage());
        }
        if (preUser == null) {
            return new Response(404, "User not found");
        }

        if (!preUser.getDispName().equals(updatedUser.getDispName())){
            try {
                userMapper.updateDispName(updatedUser.getUserName(), updatedUser.getDispName());
            } catch (Exception e){
                System.out.println(e.getMessage());
                return new Response(500, e.getMessage());
            }
        }
        if (!preUser.geteMail().equals(updatedUser.geteMail())){
            try {
                userMapper.updateEMail(updatedUser.getUserName(), updatedUser.geteMail());
            } catch (Exception e){
                System.out.println(e.getMessage());
                return new Response(500, e.getMessage());
            }
        }
        if (!preUser.getPassword().equals(updatedUser.getPassword())){
            try {
                userMapper.updatePassword(updatedUser.getUserName(), updatedUser.getPassword());
            } catch (Exception e){
                System.out.println(e.getMessage());
                return new Response(500, e.getMessage());
            }

        }

        String jsonResponse = new Gson().toJson(updatedUser);
        return new Response(200, jsonResponse);

    }



}
