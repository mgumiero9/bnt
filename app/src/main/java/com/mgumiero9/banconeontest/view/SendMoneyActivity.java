package com.mgumiero9.banconeontest.view;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mgumiero9.banconeontest.R;
import com.mgumiero9.banconeontest.controller.UserAdapter;
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

    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11,
            R.drawable.image12,
            R.drawable.image13,
            R.drawable.image14,
            R.drawable.image15 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money_list);

        hideSystemUI(this);

        /** Attaching screen elements*/
        // Get Menu element (icon)
        TextView tvBack = (TextView) findViewById(R.id.tv_back);

        /** Setting up Turbi font */
        mTypeFace = Typeface.createFromAsset(getAssets(), "fonts/custom_font.ttf");
        tvBack.setTypeface(mTypeFace);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

/*        *//** Setting up the action bar *//*
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/

        final ArrayList<User> userList = User.getUsersFromFile("users.json", this);

/*        String[] listItems = new String[userList.size()];

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            listItems[i] = user.id + " " + user.name + user.photo + " " + user.phone;
        }*/

        // First used adapter
/*        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);*/

        mListView = (ListView) findViewById(R.id.user_list_view);

        UserAdapter adapter = new UserAdapter(this, userList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "You Clicked at: " + position, Toast.LENGTH_SHORT).show();

                // Add the fragment to the 'loading_text_fragment_container' FrameLayout
                ValueFragment valueFragment = new ValueFragment();
                getFragmentManager().beginTransaction()
                        .add(R.id.container, valueFragment)
                        .commit();

                /*ImageView ibPic = (ImageView) view.findViewById(R.id.iv_pic_fragment);
                ibPic.setImageResource(imageId[position]);*/

            }
        });


    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */

    private static void hideSystemUI(Activity activity) {
        View view = activity.getWindow().getDecorView();
        hideSystemUI(view);
    }

    private static void hideSystemUI(View view) {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

}
