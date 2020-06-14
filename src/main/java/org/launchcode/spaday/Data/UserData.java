package org.launchcode.spaday.Data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;

public class UserData {
    static User user = new User();
    static ArrayList<User> users = new ArrayList<>();

    public void addUser(){
        if(user != user){
            users.add(user);
        }
    }

    public static ArrayList<User> getAll(){
        return users;
    }

    public User getById(){
        user.getId();
        return user;
    }
}
