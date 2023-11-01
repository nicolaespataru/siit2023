package org.example;

public class Message {
    private String phoneNumber;
    private String content;

    public Message(String phoneNumber, String content) {
        this.phoneNumber = phoneNumber;
        this.content = content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void getContent() {
        System.out.println(this.content);
    }
}