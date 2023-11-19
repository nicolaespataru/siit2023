package org.example;
import java.util.Scanner;

public class ConsoleScanner {
    public String readLine() {
        System.out.println("Enter the expression: ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
