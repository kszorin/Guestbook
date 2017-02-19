package com.kszorin.guestbook.activities;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentTransaction;

import com.kszorin.guestbook.R;
import com.kszorin.guestbook.fragments.StartPageFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //отображаем StartPageFragment (начальная страница)
            StartPageFragment startPageFrag = new StartPageFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.replace(R.id.fragment_container, startPageFrag);
            ft.commit();
        }
    }
}
