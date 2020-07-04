package org.launchcode.spaday.Data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;

public class UserData {
    static User user = new User();
    static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User u){
        if(user != u){
            users.add(u);
        }
    }

    public static ArrayList<User> getAll(){
        return new ArrayList<>(users);
    }

    public User getById(){
        user.getId();
        return user;
    }
}
