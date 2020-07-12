package com.example.h2o;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    TextView showCountTextView;
    TextView showCountDownTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        showCountDownTextView = fragmentFirstLayout.findViewById(R.id.textView3);
        // Inflate the layout for this fragment
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.water_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast waterToast = Toast.makeText(getActivity(), "You drank water!", Toast.LENGTH_SHORT);
                waterToast.show();
                countMe(view);
                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        showCountDownTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        showCountDownTextView.setText("done!");
                    }
                }.start();
            }
        });


    }

    private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();
        // Convert value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }
}