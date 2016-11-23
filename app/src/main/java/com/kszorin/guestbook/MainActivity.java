package com.kszorin.guestbook;

import android.app.Activity;
import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.FragmentTransaction;
import android.widget.TextView;

public class MainActivity extends Activity {

    //добавить сохранение состояния и разобраться  с пропаданием стартовой страницы
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
