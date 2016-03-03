package com.sparsh.sparsh.shreedhamgirlspg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button gobutton;


    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(com.sparsh.sparsh.shreedhamgirlspg.R.layout.fragment_main, container, false);




        gobutton = (Button) view.findViewById(com.sparsh.sparsh.shreedhamgirlspg.R.id.button);
        gobutton.setEnabled(true);

        gobutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getContext(), Main2Activity.class);
                        startActivity(intent);


                    }
                });


        return view;
    }


}
