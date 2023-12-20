package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Filter.filterDataByBirthday;

public class Writer {

    static Filter filter;

    public static void start(String[] input) {
        if (input.length != 3) {
            System.out.println("Input type: BirthdayFilter <input_filename> <target_month> <output_filename>");
            return;
        }

        String inputFileName = input[0];
        int targetMonth = Integer.parseInt(input[1]);
        String outputFileName = input[2];

        try {
            filter = new Filter();
            List<String> filteredData = filter.filterDataByBirthday(inputFileName, targetMonth);

            filteredData.sort(Comparator.naturalOrder());

            filteredData.forEach(System.out::println);

            Files.write(Paths.get(outputFileName), filteredData);

            System.out.println("Output written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}