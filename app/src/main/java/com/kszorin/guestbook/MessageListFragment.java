package com.kszorin.guestbook;

import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class MessageListFragment extends Fragment {

    ListView messageListView;

    public MessageListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);


        /*
        //для варианта с тестовым массивом
        MessagesDao messages = new MessagesList();
        if (view != null) {
            messageListView = (ListView) view.findViewById(R.id.message_list_listview);
            MessageListAdapter messageListAdapter = new MessageListAdapter(view.getContext(), messages.getAllMessages());
            messageListView.setAdapter(messageListAdapter);
        }*/

        GuestbookDatabaseHelperSingleton guestbookDatabaseHelperSingleton = GuestbookDatabaseHelperSingleton.getInstance(view.getContext());
        MessagesDao messages = new MessagesDb(guestbookDatabaseHelperSingleton.getGuestbookDatabaseHelper(), view.getContext());

        if (view != null) {
            messageListView = (ListView) view.findViewById(R.id.message_list_listview);
            MessageListAdapter messageListAdapter = new MessageListAdapter(view.getContext(), messages.getAllMessages());
            messageListView.setAdapter(messageListAdapter);
        }


        return view;
    }

}
