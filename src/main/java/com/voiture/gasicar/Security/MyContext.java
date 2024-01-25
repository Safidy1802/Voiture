package com.voiture.gasicar.Security;

import com.voiture.gasicar.Model.User;

public class MyContext {
    private static final ThreadLocal<User> user=new ThreadLocal<>();
    // private static final DAO requester=new DAO("postgres", "root", "localhost","final", "postgresql");
    public static User getUser(){
        return user.get();
    }

    public static void setUser(User person){
        user.set(person);
    }
}
