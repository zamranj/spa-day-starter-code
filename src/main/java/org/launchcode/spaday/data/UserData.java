package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static final Map<Integer, String> users =new HashMap<>();

    public static void add(User user){

        users.put(user.getId(), user.getEmail());

    }

    public static Collection<String> getAll(){
        return users.values();
    }

    public static String getById(int id){

        return users.get(id);
    }
}
