package com.sparsh.sparsh.shreedhamgirlspg.Reach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sparsh.sparsh.shreedhamgirlspg.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.sparsh.sparsh.shreedhamgirlspg.R.layout.reach;


/**
 * Created by spars on 20-12-2015.
 */
public class Reach extends Fragment implements AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    private int result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v =inflater.inflate(reach,container,false);

        Spinner spinner=(Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinneradapter=ArrayAdapter.createFromResource(getContext(),R.array.places_of_interest,android.R.layout.simple_spinner_item);
        /*spinneradapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinneradapter);

        spinner.setOnItemSelectedListener(this);*/

        result=GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if(result!=ConnectionResult.SUCCESS)
        {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(result,getActivity(),69);
            dialog.setCancelable(true);
            dialog.show();
        }
        else{
            mMap = ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map)).getMap();

            MarkerOptions markeroption;
            LatLng position;

            markeroption=new MarkerOptions();

            if(isGooglemapsinstalled())
            {
                position=new LatLng(28.7044009,77.1841827);
                markeroption.position(position);
                markeroption.title("Shreedham Girls' PG");
                mMap.addMarker(markeroption);
                CameraUpdate cameraposition= CameraUpdateFactory.newLatLngZoom(position,16.0f);
                mMap.animateCamera(cameraposition);

            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Please install Google Maps");
                builder.setCancelable(true);
                builder.setPositiveButton("Install", getGoogleMapsListener());
                AlertDialog dialog =builder.create();
                dialog.show();
            }


        }

        return v;
    }

    public boolean isGooglemapsinstalled()
    {

        try
        {
            ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }

    public DialogInterface.OnClickListener getGoogleMapsListener()
    {
        return  new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps"));
                startActivity(i);

            }
        };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==3)
        {


            Fragment newfragment= new Reachwithinput();
            android.support.v4.app.FragmentManager fm=getActivity().getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.reach,newfragment);

            Log.e("onItemSelected: ", "in if loop");



        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}



