package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<String> filterDataByBirthday(String inputFileName, int targetMonth) throws IOException {
        return Files.lines(Paths.get(inputFileName))
                .map(line -> line.split(","))
                .filter(parts -> parts.length == 3)
                .filter(parts -> {
                    String[] dateParts = parts[2].trim().split("/");
                    if (dateParts.length == 3) {
                        int birthMonth = Integer.parseInt(dateParts[0].trim());
                        return birthMonth == targetMonth;
                    }
                    return false;
                })
                .map(parts -> parts[0].trim() + ", " + parts[1].trim())
                .collect(Collectors.toList());
    }
}
