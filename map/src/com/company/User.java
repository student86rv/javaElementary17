package com.company;

public class User {

    private String name;
    private int age;
    private String group;
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
