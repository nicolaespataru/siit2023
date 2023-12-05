package org.example;
import java.util.Scanner;

public class ConsoleScanner {
    public String readLine() {
        System.out.println("Enter path for the CSV: ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
