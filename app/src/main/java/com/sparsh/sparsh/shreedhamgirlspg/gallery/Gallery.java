package com.sparsh.sparsh.shreedhamgirlspg.gallery;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.sparsh.sparsh.shreedhamgirlspg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spars on 20-12-2015.
 */
public class Gallery extends Fragment implements ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener {

    ViewPager viewPager;
    TabHost tabhost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.gallery,container,false);

        initViewPager(v);

        initTabHost(v);

        return v;
    }

    private void  initTabHost(View v){

        tabhost = (TabHost)v.findViewById(R.id.tabHost);
        tabhost.setup();

        String[] tabnames={"PG","Rooms","Dinning Hall","Office","Washrooms",};

        for (int i=0;i<tabnames.length;i++)
        {
            TabHost.TabSpec tabspec;
            tabspec = tabhost.newTabSpec(tabnames[i]);
            tabspec.setIndicator(tabnames[i]);
            tabspec.setContent(new FakeContent(getContext()));
            tabhost.addTab(tabspec);

        }
        tabhost.setOnTabChangedListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectPage) {

        tabhost.setCurrentTab(selectPage);

    }

    @Override
    public void onPageScrollStateChanged(int position) {

    }

    @Override
    public void onTabChanged(String tabId) {

        int selectPage=tabhost.getCurrentTab();
        viewPager.setCurrentItem(selectPage);

        HorizontalScrollView hscrollview;
        hscrollview = (HorizontalScrollView)getView().findViewById(R.id.hscrollview);
        View tabview=tabhost.getCurrentTabView();
        int scrollPos=tabview.getLeft()-(hscrollview.getWidth()-tabview.getWidth())/2;
        hscrollview.smoothScrollTo(scrollPos,0);

    }

    public class FakeContent implements TabHost.TabContentFactory{


        Context context;
        public FakeContent(Context mcontext) {
            context=mcontext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeview = new View(context);
            fakeview.setMinimumHeight(0);
            fakeview.setMinimumWidth(0);
            return fakeview;
        }
    }

    private void initViewPager(View v){
        viewPager=(ViewPager)v.findViewById(R.id.view_pager);
        List<Fragment> listfragments= new ArrayList();
        listfragments.add(new galleryfragment1());
        listfragments.add(new galleryfragment2());
        listfragments.add(new galleryfragment3());
        listfragments.add(new galleryfragment4());
        listfragments.add(new galleryfragment5());
        FragmentManager fragmentmanager= getActivity().getSupportFragmentManager();
        galleryhandler mygallerypager=new galleryhandler(fragmentmanager,listfragments);
        viewPager.setAdapter(mygallerypager);
        viewPager.setOnPageChangeListener(this);

    }

}
