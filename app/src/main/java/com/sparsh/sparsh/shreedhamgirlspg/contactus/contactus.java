package com.sparsh.sparsh.shreedhamgirlspg.contactus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sparsh.sparsh.shreedhamgirlspg.R;

import java.net.URI;

/**
 * Created by spars on 04-01-2016.
 */
public class contactus extends Fragment{

    ImageView fbimg;
    ImageView callimg;
    ImageView mailimg;
    ImageView webimg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.contactus, container, false);

        webimg=(ImageView)v.findViewById(R.id.webimg);
        final Uri webpage = Uri.parse("http://www.delhigirlspg.com");

        webimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webintent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webintent);
            }
        });


        fbimg=(ImageView)v.findViewById(R.id.fbimg);
        final Uri fbpage = Uri.parse("https://www.facebook.com/ShreedhamGirlsPGDelhi/");

        fbimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fbintent = new Intent(Intent.ACTION_VIEW, fbpage);
                startActivity(fbintent);
            }
        });


        mailimg=(ImageView)v.findViewById(R.id.mailimg);

        mailimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shreedhamknp@gmail.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query regarding PG");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                startActivity(emailIntent);

            }
        });


        PhoneCallListener phoneListener = new PhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager) getContext()
                .getSystemService(getContext().TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        callimg=(ImageView)v.findViewById(R.id.callimg);
        final Uri callno=Uri.parse("tel:8882746436");

        callimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent = new Intent(Intent.ACTION_DIAL, callno);
                startActivity(callintent);
            }
        });


        return v;
    }


    private class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = getContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    getContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                    isPhoneCalling = false;
                }
            }
        }
    }



}


