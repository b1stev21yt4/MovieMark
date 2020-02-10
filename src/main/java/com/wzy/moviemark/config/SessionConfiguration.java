package com.wzy.moviemark.config;

import com.wzy.moviemark.model.User;

import java.util.*;

public class SessionConfiguration {

    private static SessionConfiguration instance = null;
    private Map<String, User> sessionMap = new HashMap<>();
    private Set<String> userSet = new HashSet<>();

    public static synchronized SessionConfiguration getInstance() {
        if (instance == null) {
            instance = new SessionConfiguration();
        }
        return instance;
    }


    public Map<String, User> getSessionMap() {
        return sessionMap;
    }

    public Set<String> getUserSet() {
        return userSet;
    }

    public String addSession(User user){
        String uuid = UUID.randomUUID().toString();
        this.sessionMap.put(uuid, user);
        this.userSet.add(user.getUserName());
        return uuid;
    }

    public void removeSession(String sessionId) {
        if (this.containsSession(sessionId)){
            User user = this.getUserBySession(sessionId);
            this.sessionMap.remove(sessionId);
            this.userSet.remove(user.getUserName());
        }
    }


    public boolean containsSession(String sessionId) {
        return this.sessionMap.containsKey(sessionId);
    }

    public User getUserBySession(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)){
            return this.sessionMap.get(sessionId);
        }
        return null;
    }

    public boolean isUserLogin(User user){
        return this.userSet.contains(user.getUserName());
    }



}
