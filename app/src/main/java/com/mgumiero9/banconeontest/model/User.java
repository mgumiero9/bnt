package com.mgumiero9.banconeontest.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by mgumiero9 on 24/03/17.
 */

public class User {

    private final static String TAG = User.class.getSimpleName();

    public String id;
    public String name;
    public int phone;
    public String photo;
    public String email;

    /** json File - Read procedure */
    public static ArrayList<User> getUsersFromFile(String filename, Context context){
        final ArrayList<User> userList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("utils/users.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray users = json.getJSONArray("users");

            // Get Car objects from data
            for (int i = 0; i < users.length(); i++) {
                User user = new User();

                Log.e(TAG, i + " " + users.length());

                user.id = users.getJSONObject(i).getString("id");
                user.name = users.getJSONObject(i).getString("name");
                user.photo = users.getJSONObject(i).getString("photo");
                user.phone = users.getJSONObject(i).getInt("phone");

                userList.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userList;
    }

    /** json File - Read procedure - Read json file */
    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
