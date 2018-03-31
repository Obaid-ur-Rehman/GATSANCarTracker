package com.gatsan.track.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gatsan.track.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Information extends Fragment {

    TextView name, email, expiry, phone;
    View inflatView;

    public Information() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatView = inflater.inflate(R.layout.fragment_information, container, false);

        name = (TextView) inflatView.findViewById(R.id.tvName);
        email = (TextView) inflatView.findViewById(R.id.tvEmail);
        expiry = (TextView) inflatView.findViewById(R.id.tvExpiry);
        phone = (TextView) inflatView.findViewById(R.id.tvPhone);
        return inflater.inflate(R.layout.fragment_information, container, false);
    }

    public void updateInformation(String packet)
    {
        String[] info = packet.split(",");
        name.setText(info[0]);
        email.setText(info[1]);
        expiry.setText(info[2]);
        phone.setText(info[3]);


    }

}
