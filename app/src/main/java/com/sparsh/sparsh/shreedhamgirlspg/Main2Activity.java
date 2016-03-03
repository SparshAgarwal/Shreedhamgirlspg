package com.sparsh.sparsh.shreedhamgirlspg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

import com.sparsh.sparsh.shreedhamgirlspg.Home.Home;
import com.sparsh.sparsh.shreedhamgirlspg.Reach.Reach;
import com.sparsh.sparsh.shreedhamgirlspg.contactus.contactus;
import com.sparsh.sparsh.shreedhamgirlspg.facilities.facilities;
import com.sparsh.sparsh.shreedhamgirlspg.gallery.Gallery;
import com.sparsh.sparsh.shreedhamgirlspg.lodging.lodginglist;
import com.sparsh.sparsh.shreedhamgirlspg.nearbycolleges.collegelist;
import com.sparsh.sparsh.shreedhamgirlspg.rooms.rooms;

public class Main2Activity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    public FragmentManager fragmentManager = getSupportFragmentManager();


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private ShareActionProvider mShareActionProvider;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sparsh.sparsh.shreedhamgirlspg.R.layout.activity_main2);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(com.sparsh.sparsh.shreedhamgirlspg.R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                com.sparsh.sparsh.shreedhamgirlspg.R.id.navigation_drawer,
                (DrawerLayout) findViewById(com.sparsh.sparsh.shreedhamgirlspg.R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Home();
                break;
            case 1:
                //fragment = new lodginglist();
                fragment = new rooms();
                break;
            case 2:
                fragment = new facilities();
                break;
            case 3:
                fragment = new Gallery();
                break;
            case 4:
                fragment = new collegelist();
                break;
            case 5:
                fragment = new Reach();
                break;
            case 6:
                fragment = new contactus();
                break;
            default:
                break;
        }
        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(com.sparsh.sparsh.shreedhamgirlspg.R.id.container, fragment).commit();
            onSectionAttached(position);

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section1);
                break;
            case 1:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section2);
                break;
            case 2:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section3  );
                break;
            case 3:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section4);
                break;
            case 4:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section5);
                break;
            case 5:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section6);
                break;
            case 6:
                mTitle = getString(com.sparsh.sparsh.shreedhamgirlspg.R.string.title_section7);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(com.sparsh.sparsh.shreedhamgirlspg.R.menu.main2, menu);
            restoreActionBar();

            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.sparsh.sparsh.shreedhamgirlspg.R.id.action_settings) {
            return true;
        }
        else if (id == com.sparsh.sparsh.shreedhamgirlspg.R.id.action_share) {
            Intent i= new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT,"Shreedham PG");
            String sAux="Download this interesting app https://play.google.com/store/apps/details?id=com.sparsh.sparsh.shreedhamgirlspg&hl=en";
            i.putExtra(Intent.EXTRA_TEXT,sAux);
            startActivity(Intent.createChooser(i,"Choose one"));

        }

        return super.onOptionsItemSelected(item);
    }


}
