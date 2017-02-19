package com.kszorin.guestbook.dao;

import com.kszorin.guestbook.models.Message;

import java.util.List;

/**
 * Created by kszorin on 16.11.2016.
 * DAO описания работы с хранилищем сообщений гостевой книги.
 */
public interface MessagesDao {
    public List<Message> getAllMessages();          //Возвращает коллекцию Message
    public Message getMessage (int i);              //Возвращает message с порядковым номером i.
    public Message getMessageById (int id);         //Вовзращает message, идентификатор которого равен id.
    public boolean  addMessage (Message message);   //Добавляет элемент message в хранилище. Возвращает true в случае успеха, иначе - false.
    public int updateMessage(Message message);      //Находит в хранилище элемент с таким же id как и у message, заменяет значения его полей на поля message. Если не находит, возвращает -1.
    public boolean deleteMessage (int id);          //Удаляет из хранилища элемент, идентификатор которого равен id. Возвращает true в случае успеха, иначе - false.

}
