package org.example;
import java.util.regex.*;
public class MMConverter {

    private static TermsSplitter TermsSplitter;

    public static double convert(String input) {
        TermsSplitter = new TermsSplitter();
        String[] terms = TermsSplitter.split(input);
        double result = 0;
        double termValue = 0;
        boolean additionFlag = true;

        for (String term : terms) {
            if (!term.isEmpty()) {
                if (term.equals("+")) {
                    additionFlag = true;
                } else if (term.equals("-")) {
                    additionFlag = false;
                } else {
                    String[] parts = term.split("\\s+");
                    if (parts.length != 2) {
                       return -1;
                    }
                    double value = Double.parseDouble(parts[0]);
                    String unit = parts[1].toLowerCase();

                    switch (unit) {
                        case "cm":
                            termValue = value * 10;
                            break;
                        case "dm":
                            termValue = value * 100;
                            break;
                        case "m":
                            termValue = value * 1000;
                            break;
                        case "km":
                            termValue = value * 1000000;
                            break;
                        case "mm":
                            termValue = value;
                            break;
                        default:
                            return -1;
                    }

                    // Update the result based on the term and sign
                    if (additionFlag == true)
                    {
                        result += termValue;
                    }
                    else{
                        result += (-1) * termValue;
                    }

                }
            }
        }

        return result;


        }
    }
