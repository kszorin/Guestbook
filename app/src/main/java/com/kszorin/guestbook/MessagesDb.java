package com.kszorin.guestbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kszorin on 16.11.2016.
 * Класс для работы с БД сообщений.
 */
public class MessagesDb implements MessagesDao {
    GuestbookDatabaseHelper guestbookDatabaseHelper;
    SQLiteDatabase db;
    ArrayList<Message> messages;

    public MessagesDb(GuestbookDatabaseHelper guestbookDatabaseHelper, Context context) {
        this.guestbookDatabaseHelper = guestbookDatabaseHelper;
        try {
            db = guestbookDatabaseHelper.getWritableDatabase();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(context, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
        messages = new ArrayList<Message>();
    }

    @Override
    public List<Message> getAllMessages() {

        Cursor cursor = db.query("MESSAGES",
                new String[] {"_ID","LOGIN", "ENTRY", "IMAGE_URL"},
                null, null, null, null,null);

        cursor.moveToFirst();

        for (int i=0; i<cursor.getCount(); i++) {
            messages.add(new Message(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        return messages;
    }

    @Override
    public Message getMessage(int n) {
        return null;
    }

    @Override
    public Message getMessageById(int id) {
        return null;
    }

    @Override
    public int updateMessage(Message message) {
        return 0;
    }

    @Override
    public boolean deleteMessage(int id) {
        return false;
    }

    @Override
    public boolean addMessage(Message message) {
        ContentValues messageValues = new ContentValues();
        messageValues.put("LOGIN", message.getLogin());
        messageValues.put("ENTRY", message.getEntry());
        messageValues.put("IMAGE_URL", message.getImageUrl());
        if (db.insert("MESSAGES", null, messageValues) != -1) {
            Log.i("MessageDb", "Вставка строки в таблицу MESSAGES");
            return true;
        }
        else {
            Log.e("MessageDb", "Ошибка вставки строки в таблицу MESSAGES");
            return false;
        }
    }
}
