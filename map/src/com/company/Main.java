package com.company;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, String> defaultUser = new HashMap<>();
    static {
        defaultUser.put("name", "DefaultUser");
        defaultUser.put("age", "18");
        defaultUser.put("group", "defaultGroup");
        defaultUser.put("email", "defaultUser@user.com");
    }

    public static void main(String[] args) {

        Map<String, String> userMap1 = new HashMap<>();
        userMap1.put("name", "Alex");
        userMap1.put("age", "19");
        userMap1.put("group", "java");
        userMap1.put("email", "alex1989@i.ua");
        User user1 = mapToUser(userMap1);
        System.out.println(user1);

        Map<String, String> userMap2 = new HashMap<>();
        userMap2.put("name", "Anna");
        User user2 = mapToUser(userMap2);
        System.out.println(user2);
    }

    private static User mapToUser(Map map) {

        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean isString = field.getType().equals(String.class);
            String key = field.getName();
            field.setAccessible(true);

            try {
                if (map.get(key) == null) {
                    if (isString) {
                        field.set(user, defaultUser.get(key));
                    } else {
                        field.set(user, Integer.parseInt((String)defaultUser.get(key)));
                    }
                } else {
                    if (isString) {
                        field.set(user, map.get(key));
                    } else {
                        field.set(user, Integer.parseInt((String)map.get(key)));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            field.setAccessible(false);
        }
        return user;
    }
}
