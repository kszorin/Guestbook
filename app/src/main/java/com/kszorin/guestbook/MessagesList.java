package com.kszorin.guestbook;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kszorin on 16.11.2016.
 */
public class MessagesList implements MessagesDao {

    ArrayList <Message> messages;
    int lastId;

    public MessagesList() {
        messages = new ArrayList<Message>();
        //тестовое наполнение
        Message msg1 = new Message(lastId, "Ваня","Тестовое сообщение Вани","https://pp.vk.me/c604822/v604822367/1731d/cHMr9VSNMrs.jpg");
        messages.add(msg1);
        lastId++;
        Message msg2 = new Message(lastId, "Маша","Тестовое сообщение Маши","https://pp.vk.me/c638923/v638923696/fb53/nc-kJ00qZBE.jpg");
        messages.add(msg2);
        lastId++;
        Message msg3 = new Message(lastId, "Коля","Тестовое сообщение Коли","https://pp.vk.me/c631322/v631322795/39e08/TBYWmXm2-vM.jpg");
        messages.add(msg3);
        lastId++;
    }

    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

    @Override
    public Message getMessage(int i) {
        return messages.get(i);
    }

    @Override
    public Message getMessageById (int id) {
        for (Message  message:messages
             ) {
            if (message.getId() == id)
                return message;
        }
        return null;
    }

    @Override
    public int updateMessage(Message message) {
        for (Message  msg:messages
                ) {
            if (msg.getId() == message.getId()) {
                msg.setLogin(message.getLogin());
                msg.setEntry(message.getEntry());
                msg.setImageUrl(message.getImageUrl());
                return msg.getId();
            }
        }
        return -1;
    }

    @Override
    public boolean deleteMessage(int id) {
        for (Message  message:messages
                ) {
            if (message.getId() == id){
                return messages.remove(message);
            }
        }
        return false;
    }

    @Override
    public boolean addMessage(Message message) {
        messages.add(new Message(lastId, message.getLogin(), message.getEntry(), message.getImageUrl()));
        return true;
    }
}
