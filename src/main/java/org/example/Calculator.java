package org.example;

public class Calculator {
    private final ConsoleScanner consoleScanner;
    private final MMConverter MMConverter;

    public Calculator() {
        consoleScanner = new ConsoleScanner();
        MMConverter = new MMConverter();
    }
    public void calculate() {
        String input = consoleScanner.readLine();
        System.out.println("Result: " + MMConverter.convert(input) + " mm");
    }
}
