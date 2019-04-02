package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

       Map<String, String> map = new HashMap<>();

       map.put("name","Alex");
       map.put("age", "19");

       mapToObject(map, User.class);

    }

    public static void mapToObject(Map map, Class userClass) {
        Field[] fields = userClass.getDeclaredFields();
        String[] keys = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            keys[i] = fields[i].getName();
        }

        Object newUserClass = null;
        try {
            newUserClass = userClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
