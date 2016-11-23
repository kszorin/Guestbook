package com.kszorin.guestbook;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Стартовая страница приложения.
 */
public class StartPageFragment extends Fragment {

    public StartPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_page, container, false);

        if (view != null) {
            Button addMessageButton = (Button) view.findViewById(R.id.add_message_button);          //отображаем фрагмент страницы добавления нового сообщения
            addMessageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddMessageFragment addMessageFrag = new AddMessageFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, addMessageFrag);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                }
            });

            Button messageListButton = (Button) view.findViewById(R.id.message_list_button);        //отображаем фрагмент страницы вывода списка всех сообщений
            messageListButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MessageListFragment messageListFrag = new MessageListFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, messageListFrag);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                }
            });
        }
        return view;
    }
}
