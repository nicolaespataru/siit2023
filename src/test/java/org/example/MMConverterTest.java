package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class MMConverterTest {
    @InjectMocks
    MMConverter subject;

    @Mock
    TermsSplitter termsSplitterMock;

    @BeforeEach
    public void setup(){
        termsSplitterMock = Mockito.mock(TermsSplitter.class);
    }

    @Test
    public void convert(){
        // given
        String input = "2 cm + 1 mm";
        String[] terms = {"2 cm", "", "+", "1 mm"};
        double expectedResult = 21.0;
        // returnez direct inputul meu
        Mockito.when(termsSplitterMock.split(input)).thenReturn(terms);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        // when
        subject.convert(String.valueOf(terms));
        // then (punem assertions)
        Mockito.verify(termsSplitterMock, Mockito.times(1)).split(Mockito.eq(String.valueOf(terms)));
        assertEquals(input, argumentCaptor.getValue());
        assertEquals(expectedResult, subject.convert(input));
    }
}