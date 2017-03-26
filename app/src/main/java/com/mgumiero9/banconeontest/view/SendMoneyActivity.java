package com.mgumiero9.banconeontest.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mgumiero9.banconeontest.R;
import com.mgumiero9.banconeontest.model.User;

import java.util.ArrayList;

/**
 * Created by mgumiero9 on 17/02/17.
 * This is the App List screen which contains the vehicles to be booked.
 */

public class SendMoneyActivity extends AppCompatActivity {

    private static final String TAG = SendMoneyActivity.class.getSimpleName();
    private ListView mListView;
    private Typeface mTypeFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money_list);

        /** Attaching screen elements*/
        // Get Menu element (icon)
        TextView tvBack = (TextView) findViewById(R.id.tv_back);

        /** Setting up Turbi font */
        mTypeFace = Typeface.createFromAsset(getAssets(), "fonts/custom_font.ttf");
        tvBack.setTypeface(mTypeFace);

        /** Setting up the action bar */
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mListView = (ListView) findViewById(R.id.car_list_view);

        final ArrayList<User> userList = User.getUsersFromFile("users.json", this);

        String[] listItems = new String[userList.size()];

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            listItems[i] = user.id + " " + user.name + user.photo + " " + user.phone;
        }

        // First used adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);

        /*UserAdapter adapter = new UserAdapter(this, userList);
        mListView.setAdapter(adapter);*/

    }

}
