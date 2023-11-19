package org.example;
public class TermsSplitter {
    public static String[] split(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Nothing found in your expression.");
            return new String[0];
        }

        String[] terms = input.split("\\s*(?=[-+])|(?<=[-+])\\s*");

        return terms;
    }
}