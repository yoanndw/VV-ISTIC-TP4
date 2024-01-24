package fr.istic.vv;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import static org.junit.jupiter.api.Assertions.*;

import static fr.istic.vv.RomanNumeraUtils.*;

public class RomanNumeralTest {
    @Property
    boolean arabicToRomanToArabicKeepsNumber(@ForAll @IntRange(min = 0, max = 3999) int i) {
        return parseRomanNumeral(toRomanNumeral(i)) == i;
    }

    @Property
    void tooSmallNumberThrowsException(@ForAll @IntRange(min = Integer.MIN_VALUE, max = -1) int i) {
        assertThrows(RuntimeException.class, () -> toRomanNumeral(i));
    }

    @Property
    void tooBigNumberThrowsException(@ForAll @IntRange(min = 4000, max = Integer.MAX_VALUE) int i) {
        assertThrows(RuntimeException.class, () -> toRomanNumeral(i));
    }
}
