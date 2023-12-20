package org.example;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.example.Writer.filter;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    @Test
    public void testFilterDataByBirthday() throws IOException {
        List<String> filteredData = filter.filterDataByBirthday("test_input.txt", 9);
        assertEquals(2, filteredData.size());
        assertEquals("Ion, Georgescu", filteredData.get(0));
        assertEquals("Ioana, Marinescu", filteredData.get(1));
    }
}