package com.kszorin.guestbook.dbhelper;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.util.Log;

/**
 * Created by kszorin on 16.11.2016.
 * Класс для создания БД, подключения к ней, добавления начальных данных.
 */
public class GuestbookDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "guestbook_db";   // Имя базы данных
    private static final int DB_VERSION = 1;                // Версия базы данных

    public GuestbookDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MESSAGES ("
                + "_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "LOGIN TEXT, "
                + "ENTRY TEXT, "
                + "IMAGE_URL TEXT);");

        //заполнение БД первоначальными тремя сообщениями
        insertMessage(db, "Коля", "Сообщение Коли","https://pp.vk.me/c604822/v604822367/1731d/cHMr9VSNMrs.jpg");
        insertMessage(db, "Маша", "Сообщение Маши","https://pp.vk.me/c638923/v638923696/fb53/nc-kJ00qZBE.jpg");
        insertMessage(db, "Ваня", "Сообщение Вани","https://pp.vk.me/c631322/v631322795/39e08/TBYWmXm2-vM.jpg");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //используется только для вставки тестовых сообщений
    private static void insertMessage(SQLiteDatabase db, String login,
                                    String entry, String imageUrl) {
        ContentValues messageValues = new ContentValues();
        messageValues.put("LOGIN", login);
        messageValues.put("ENTRY", entry);
        messageValues.put("IMAGE_URL", imageUrl);
        if (db.insert("MESSAGES", null, messageValues) != -1)
            Log.i("insertMessage", "Вставка строки в таблицу MESSAGES");
    }
}
