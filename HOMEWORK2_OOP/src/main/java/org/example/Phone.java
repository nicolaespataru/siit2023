package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    public String IMEI;
    protected int batteryLife;
    public String color;
    public String material;
    private List<Contact> contacts = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private List<Call> callHistory = new ArrayList<>();

    public Phone() {
        this.IMEI = "Default";
        this.batteryLife = 24;
        this.color = "Default";
        this.material = "Default";
    }

    public Phone(String IMEI) {
        this.IMEI = IMEI;
        this.batteryLife = 24;
        this.color = "Default";
        this.material = "Default";
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public String getColor(){
        return this.color;
    }

    public String getMaterial(){
        return this.material;
    }
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        contacts.add(new Contact(phoneNumber, firstName, lastName));
    }

    public Contact getFirstContact() {
        return contacts.isEmpty() ? null : contacts.get(0);
    }

    public Contact getLastContact() {
        return contacts.isEmpty() ? null : contacts.get(contacts.size() - 1);
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        if (messageContent.length() <= 100 && batteryLife >= 1) {
            messages.add(new Message(phoneNumber, messageContent));
            batteryLife -= 1;
        }
    }

    public void getFirstMessage(String phoneNumber) {
        for (Message message : messages) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                message.getContent();
            }
            else System.out.println("null");
        }
    }


    public Message getSecondMessage(String phoneNumber) {
        int count = 0;
        for (Message message : messages) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                count++;
                if (count == 2) {
                    return message;
                }
            }
        }
        return null;
    }


    public void call(String phoneNumber) {
        if (batteryLife >= 2) {
            callHistory.add(new Call(phoneNumber));
            batteryLife -= 2;
        }
    }


    public void viewHistory() {
        if (callHistory.isEmpty()) {
            System.out.println("Call History: null");
        }
        else {
            for (Call call : callHistory) {
                System.out.println("Call to: " + call.getPhoneNumber());
            }
        }
    }

    public void getContactIndex(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index-1);
            System.out.println("Contact ID: " + index);
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
        }
        else System.out.println("null");
    }

    public void getIMEI(){
        System.out.println(this.IMEI);
    }
}
