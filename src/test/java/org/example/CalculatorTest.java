package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
        @InjectMocks
        private Calculator subject;

        @Mock
        private ConsoleScanner consoleScanner;

        @Mock
        private MMConverter MMConverter;

        @BeforeEach
        public void setup() {
                consoleScanner = Mockito.mock(ConsoleScanner.class);
                MMConverter = Mockito.mock(MMConverter.class);
                subject = new Calculator();
        }

        @Test
        public void calculator() {
                // given
                String input = "1 cm + 1 mm";
                // cand metoda consoleScanner.readLine() este apelata returnez direct inputul meu
                Mockito.when(consoleScanner.readLine()).thenReturn(input);
                ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
                // when
                subject.calculate();
                // then
                Mockito.verify(consoleScanner, Mockito.times(1)).readLine();
                Mockito.verify(MMConverter, Mockito.times(1)).convert(argumentCaptor.capture());
                assertEquals(input, argumentCaptor.getValue());
        }

        @Test
        public void test(){
                //given
                double expectedResult = 21.0;
                String input = "1 cm + 1 mm";
                String expectedOutput = "Result: " + expectedResult + " mm";
                Mockito.when(consoleScanner.readLine()).thenReturn(input);
                //when
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                subject.calculate();
                System.setOut(System.out);

                // Get the captured output as a string
                String output = outputStream.toString().trim();
                //then
                assertEquals(expectedOutput, output);
        }
}