package com.kszorin.guestbook.models;

/**
 * Created by kszorin on 10.11.2016.
 * Класс, описывающий сообщение гостевой книги.
 */
public class Message {
    private int id;             //id сообщения
    private String login;       //имя пользователя
    private String entry;       //текст записи
    private String imageUrl;    //URL картинки

   public Message (int id, String login, String entry, String imageUrl) {
        this.id = id;
        this.login = login;
        this.entry = entry;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEntry() {
        return entry;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
