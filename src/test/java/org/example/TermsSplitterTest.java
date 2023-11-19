package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TermsSplitterTest {
    TermsSplitter subject;
    @BeforeEach
    public void setup() {
        subject = new TermsSplitter();
    }

    @Test
    public void split() {
        //given
        String input = "3 cm + 2 mm";

        //when
        String[] result = subject.split(input);

        //then
        String[] expectedResult = new String[]{"3 cm", "", "+", "2 mm"};
        assertArrayEquals(expectedResult, result);
    }
    @Test
    public void split_whenSentenceIsEmpty() {
        // given
        String sentence = "";
        //when
        String[] result = subject.split(sentence);
        //then
        assertEquals(0, result.length);
    }

    @Test
    public void split_whenSentenceIsNull() {
        // given
        String sentence = null;
        //when
        String[] result = subject.split(sentence);
        //then
        assertEquals(0, result.length);
    }
    //Parametrized test version
    private static Stream<Arguments> provideArgumentsForScan() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForScan")
    public void scan(String sentence, int expectedResult) {
        //given
        //dat ca argument

        //when
        String[] result = subject.split(sentence);
        //then
        Mockito.verify(subject, Mockito.times(1)).split(Mockito.eq(sentence));
        assertEquals(expectedResult, result.length);
    }

}
