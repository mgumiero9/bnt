package com.mgumiero9.banconeontest.controller;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgumiero9.banconeontest.R;
import com.mgumiero9.banconeontest.model.User;

import java.util.ArrayList;

/**
 * Created by mgumiero9 on 18/02/17.
 */

public class UserAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<User> mDataSource;
    private Typeface mTypeFace;
    private String mImageString;

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
        TextView tvName = (TextView) rowView.findViewById(R.id.tv_name);

        // Get Brand element
        TextView tvPhone = (TextView) rowView.findViewById(R.id.tv_phone);

        // Get ListCarImage element
        ImageView ivPhoto = (ImageView) rowView.findViewById(R.id.iv_photo);

        /** Selecting the item position */
        User user = (User) getItem(position);

        /** Attaching parameters to the view */
        tvName.setText(user.name);
        tvPhone.setText(user.phone);
        //ivPhoto.setImageResource(imageId[0]);

        /* OBSOLETE: To insert image url if needed */
        //Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}
