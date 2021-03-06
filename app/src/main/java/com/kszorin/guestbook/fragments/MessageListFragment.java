package com.kszorin.guestbook.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kszorin.guestbook.dbhelper.GuestbookDatabaseHelperSingleton;
import com.kszorin.guestbook.adapters.MessageListAdapter;
import com.kszorin.guestbook.dao.MessagesDao;
import com.kszorin.guestbook.daoimpl.MessagesDaoImpl;
import com.kszorin.guestbook.R;

/*
   Класс страницы вывода всех сообщений гостевой книги.
 */

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

        //создаём синглетон для доступа к БД
        GuestbookDatabaseHelperSingleton guestbookDatabaseHelperSingleton = GuestbookDatabaseHelperSingleton.getInstance(view.getContext());
        MessagesDao messages = new MessagesDaoImpl(guestbookDatabaseHelperSingleton.getGuestbookDatabaseHelper(), view.getContext());

        if (view != null) {                                                                         //устанавливаем адаптер на ListView
            messageListView = (ListView) view.findViewById(R.id.message_list_listview);
            MessageListAdapter messageListAdapter = new MessageListAdapter(view.getContext(), messages.getAllMessages());
            messageListView.setAdapter(messageListAdapter);
        }
        return view;
    }
}
