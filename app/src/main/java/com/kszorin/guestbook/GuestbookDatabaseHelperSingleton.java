package com.kszorin.guestbook;

import android.content.Context;
import android.util.Log;

/**
 * Created by kszorin on 18.11.2016.
 * Синглетон для guestbookDatabaseHelper
 */
public class GuestbookDatabaseHelperSingleton {
    private static GuestbookDatabaseHelperSingleton instance;
    private GuestbookDatabaseHelper guestbookDatabaseHelper;

    public static GuestbookDatabaseHelperSingleton getInstance(Context context){
        Log.i("GuestbookSingleton", "getInstance");
        if (instance == null)
            instance = new GuestbookDatabaseHelperSingleton(context);
        return instance;
    }

    private GuestbookDatabaseHelperSingleton(Context context){
        Log.i("GuestbookSingleton", "Конструктор");
        guestbookDatabaseHelper = new GuestbookDatabaseHelper(context);
    }

    public GuestbookDatabaseHelper getGuestbookDatabaseHelper() {
        return guestbookDatabaseHelper;
    }

    public void setGuestbookDatabaseHelper(GuestbookDatabaseHelper guestbookDatabaseHelper) {
        this.guestbookDatabaseHelper = guestbookDatabaseHelper;
    }
}
