package com.gatsan.track.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gatsan.track.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryRecords extends Fragment {


    public HistoryRecords() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_records, container, false);
    }

}
