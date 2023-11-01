package org.example;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
        //    Phone phone= new Samsung(); // shouldn't compile

        Phone phone = new SamsungGalaxy6();

        phone.addContact("1", "phone number", "first name", "last name");

        phone.addContact("2", "second phone number", "second first name", "second last name");

        phone.getFirstContact();

        phone.getLastContact();

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendMessage("phone number", "message content");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone.call("second phone number");

        phone.viewHistory();

// 2 new contacts

        phone.addContact("3", "0712 345 678", "Gigel", "Popescu");

        phone.addContact("4", "0711 234 567", "Ion", "Constantin");

        Phone phone2 = new SamsungGalaxyS23();
        Phone phone3 = new iPhone15S("ABCD12345678");
        Phone phone4 = new iPhone15Pro();
        phone4.getIMEI();

        phone.getContactIndex(3);

    }
}
