package com.liudonghua.android.demo.nestedtabdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SubTwoFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_two_fragment_view, null);
        Button getFragmentButton = (Button) rootView.findViewById(R.id.get_OneFragment_OneTab);
        Button sendBroadcastreceiver = (Button) rootView.findViewById(R.id.send_broadcastreceiver);
        getFragmentButton.setOnClickListener(this);
        sendBroadcastreceiver.setOnClickListener(this);


        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_OneFragment_OneTab:
                SubOneFragment subOneFragment = (SubOneFragment) ((MainActivity)(getActivity())).getFragment(0);
                Fragment fragment = subOneFragment.getFragment(0);
                Toast.makeText(getActivity(), fragment.getId(), Toast.LENGTH_LONG).show();
                break;
            case R.id.send_broadcastreceiver:
                Intent intent = new Intent();
                intent.setAction("my-event");
                intent.putExtra("message", "come from SubTwoFragment");
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);

                break;
        }
    }
}
