package com.mgumiero9.banconeontest.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgumiero9.banconeontest.R;
import com.mgumiero9.banconeontest.model.User;

import java.util.ArrayList;

import com.mgumiero9.banconeontest.model.User;
import com.mgumiero9.banconeontest.FullscreenActivity;

/**
 * Created by mgumiero9 on 18/02/17.
 */

public class UserAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<User> mDataSource;
    private Typeface mTypeFace;

    public UserAdapter(Context context, ArrayList<User> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Todo: Check other optional suggestion for scrolling smoother
        View rowView = mInflater.inflate(R.layout.list_item_user, parent, false);


        // Get License Plate element
        TextView tvLicensePlate = (TextView) rowView.findViewById(R.id.tv_list_license_plate);

        // Get Brand element
        TextView tvBrandModel = (TextView) rowView.findViewById(R.id.tv_list_brand_model);

        // Get Fuel Level element
        TextView tvFuelLevel = (TextView) rowView.findViewById(R.id.tv_list_fuel_level);

        // Get Address element
        TextView tvAddress = (TextView) rowView.findViewById(R.id.tv_list_address);

        // Get Name element
        TextView tvName = (TextView) rowView.findViewById(R.id.tv_list_name);

        // Get Distance element
        TextView tvDistance = (TextView) rowView.findViewById(R.id.tv_list_distance);

        // Get ListCarImage element
        ImageView ivListCarImage = (ImageView) rowView.findViewById(R.id.iv_list_car);

        // Get Buddy element
        TextView tvBuddy = (TextView) rowView.findViewById(R.id.tv_list_buddy);

        // Get Bomb element
        TextView tvBomb = (TextView) rowView.findViewById(R.id.tv_list_bomb);

        // Get Place element
        TextView tvPlace = (TextView) rowView.findViewById(R.id.tv_place);

        // Get Transmission Icon element
        TextView tv_transmission_icon = (TextView) rowView.findViewById(R.id.tv_transmission_icon);

        // Get Transmission element
        TextView tv_transmission = (TextView) rowView.findViewById(R.id.tv_transmission);

        // Get Reserva button
        Button btnBookCar = (Button) rowView.findViewById(R.id.btn_book_car);

        /** Setting up Turbi font */
        mTypeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/untitled_font_7.ttf");
        tvBuddy.setTypeface(mTypeFace);
        tvBomb.setTypeface(mTypeFace);
        tvPlace.setTypeface(mTypeFace);
        tv_transmission_icon.setTypeface(mTypeFace);

        /** Selecting the item position */
        User user = (User) getItem(position);

        /** Attaching parameters to the view */
        tvLicensePlate.setText(user.license_plate);
        tvBrandModel.setText(user.brand + " " + user.model);
        tvAddress.setText(user.address + ", " + user.number);
        tvName.setText(user.name);
        tvDistance.setText(user.distance);
        tv_transmission.setText(user.transmission);

        /** Attaching the proper ImageView according to the Brand | Model | Color */
        switch (user.brand) {
            case "Hyundai":
                ivListCarImage.setImageResource(R.drawable.img_hb20);
                break;
            case "Jeep" :
                ivListCarImage.setImageResource(R.drawable.img_renegade);
                break;
            case "Mini" :
                ivListCarImage.setImageResource(R.drawable.img_mini);
                break;
        }

        /** Attaching proper transmission icon */
        if (user.transmission.equals("Manual")) {
            tv_transmission_icon.setText("A");
        } else {
            tv_transmission_icon.setText("z");
        }

        /** Turning double into percentual */
        double mPercentFuelLevel = Double.parseDouble(user.fuel_level) * 100;
        String mPercentFuelLevelString = String.valueOf(mPercentFuelLevel) + " %";
        tvFuelLevel.setText(mPercentFuelLevelString);

        /** OBSOLETE: To insert image url if needed */
        //Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        btnBookCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FirstActivity.class);
                mContext.startActivity(intent);
            }
        });

        return rowView;
    }
}
