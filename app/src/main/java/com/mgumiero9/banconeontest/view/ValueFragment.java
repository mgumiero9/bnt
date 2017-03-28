package com.mgumiero9.banconeontest.view;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mgumiero9.banconeontest.R;

/**
 * Created by mgumiero9 on 27/03/17.
 */

public class ValueFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    private static final String TAG = ValueFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Typeface mTypeFace;
    private Typeface mTypeFaceProximaRegular;
    private Typeface mTypeFaceProximaLight;
    private View view;
    private TextView mZipCodeLable;
    private Button mBtnZipCode1Next;
    private EditText etValue;
    private boolean mChkValue;

    public ValueFragment() {
        // Required empty public constructor
    }

    public static ValueFragment newInstance() {
        return new ValueFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.value_fragment, container, false);

/*        TextView myTextView1=(TextView)view.findViewById(R.id.profileTextView);
        TextView myTextView2=(TextView)view.findViewById(R.id.photoTextView);
        TextView myTextView3=(TextView)view.findViewById(R.id.cnhTextView);
        TextView myTextView4=(TextView)view.findViewById(R.id.creditTextView);
        mTypeFace = Typeface.createFromAsset(getActivity().getAssets(),"fonts/untitled_font_5.ttf");
        myTextView1.setTypeface(mTypeFace);
        myTextView2.setTypeface(mTypeFace);
        myTextView3.setTypeface(mTypeFace);
        myTextView4.setTypeface(mTypeFace);*/

        etValue = (EditText) view.findViewById(R.id.et_value);

        //etValue.addTextChangedListener(MaskUtil.insert(etValue, MaskType.CValue));

        //mTypeFaceProximaRegular = Typeface.createFromAsset(getActivity().getAssets(),"fonts/proximanova_regular.otf");
        //mTypeFaceProximaLight = Typeface.createFromAsset(getActivity().getAssets(),"fonts/proximanova_light.otf");

        //etValue.setTypeface(mTypeFaceProximaLight);

        /** Checking Zipcode validity */
        etValue.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                String mStr = etValue.getText().toString();
                mStr = mStr.replaceAll("\\D+","");
                //mChkValue = isValidZipcode(mStr);
                Log.e(TAG, "Valid Zipcode? " + mChkValue);
/*                if (mChkValue) {
                    mBtnZipCode1Next.setBackgroundResource(R.drawable.btn_next_shape_full);
                    mBtnZipCode1Next.setTextColor(getResources().getColor(R.color.white));
                } else {
                    mBtnZipCode1Next.setBackgroundResource(R.drawable.btn_next_shape);
                    mBtnZipCode1Next.setTextColor(getResources().getColor(R.color.blueDark1));
                }*/
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
        /***/

/*        mBtnZipCode1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mChkZipcode) {
                    String mZipPref = "";
                    SharedPreferences myPreferences = getActivity().getPreferences(0);
                    String mSavedZip = myPreferences.getString(mZipPref,"0");

                    SharedPreferences.Editor editor = myPreferences.edit();
                    editor.putString(mZipPref, etZipCode.getText().toString())
                            .apply();

                    AddressFragment addressFragment = new AddressFragment();
                    getActivity().getFragmentManager().beginTransaction()
                            .replace(R.id.container, addressFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    etZipCode.requestFocus();
                    etZipCode.setError("CEP Inválido...");
                }

            }
        });*/

        return view;
    }

    private boolean isValidZipcode(String mStr) {
        if (mStr.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (ZipcodeBroadcaster) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ZipcodeBroadcaster");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
