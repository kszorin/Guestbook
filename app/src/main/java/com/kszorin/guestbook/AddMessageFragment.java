package com.kszorin.guestbook;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Класс страницы ввода нового сообщения.
 */
public class AddMessageFragment extends Fragment {

    public AddMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_message, container, false);

        if (view != null) {
            Button downloadIconButton = (Button) view.findViewById(R.id.download_icon_button);
            downloadIconButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {                                               //обработка нажатия кнопки "Загрузить"
                    ImageView imageImageView = (ImageView) view.findViewById(R.id.image_imageview);     //область предпросмотра картинки
                    TextView imageUrlTextView = (TextView) view.findViewById(R.id.image_url_edittext);  //поле ввода URL картинки
                    Picasso.with(view.getContext())
                            .load(imageUrlTextView.getText().toString())
                            .placeholder(R.drawable.loading)                                            //картинка во время загрузки
                            .error(R.drawable.error)                                                    //картинка в случае ошибки
                            .into(imageImageView);
                }
            });

            Button sendButton = (Button) view.findViewById(R.id.send_button);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {                                                       //обработка нажатия на кнопку "Отправить"
                    GuestbookDatabaseHelperSingleton guestbookDatabaseHelperSingleton
                            = GuestbookDatabaseHelperSingleton.getInstance(view.getContext());
                    MessagesDb messages = new MessagesDb(guestbookDatabaseHelperSingleton.getGuestbookDatabaseHelper(),
                            view.getContext());

                    EditText login = (EditText) view.findViewById(R.id.login_edittext);
                    EditText entry = (EditText) view.findViewById(R.id.entry_edittext);
                    EditText imageUrl = (EditText) view.findViewById(R.id.image_url_edittext);

                    if ((!login.getText().toString().equals("")) && (!entry.getText().toString().equals(""))) {     //проверка того, что поля не пусты
                        Message message = new Message(1, login.getText().toString(), entry.getText().toString(),
                                imageUrl.getText().toString());
                        messages.addMessage(message);                                                               //добавление нового сообщения в БД

                        //переход на страницу со списком сообщений
                        MessageListFragment messageListFrag = new MessageListFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_container, messageListFrag);
                        ft.addToBackStack(null);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                    }
                }
            });
        }
        return view;
    }
}
