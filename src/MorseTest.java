

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MorseTest {

    @Test
    void testM() {
        String expected = "--";
        String actual = Morse.toMorseCode("M");
        assertEquals(expected, actual);
    }

    @Test
    void testABC() {
        String expected = ".- -... -.-.";
        String actual = Morse.toMorseCode("ABC");
        assertEquals(expected, actual);
    }

    @Test
    void THANKYOU() {
        String expected = "THANKYOU";
        String actual = Morse.fromMorseCode("- .... .- -. -.- -.-- --- ..-");
        assertEquals(expected, actual);
    }

    @Test
    void testNumbers() {
        String expected = "Please write characters A-Z";
        String actual = Morse.toMorseCode("123");
        assertEquals(expected, actual);
    }

    @Test
    void testNull() {
        String expected = "Error: Input can't be empty.";
        String actual = Morse.fromMorseCode(null);
        assertEquals(expected, actual);
    }

    @Test
    void testSwedishLetter() {
        String expected = "Error. Invalid input";
        String actual = Morse.fromMorseCode("Å");
        assertEquals(expected, actual);
    }

    @Test
    void THANK_YOU() {
        String expected = "- .... .- -. -.- -.-- --- ..-";
        String actual = Morse.toMorseCode("Thank you");
        assertEquals(expected, actual);
    }
}
