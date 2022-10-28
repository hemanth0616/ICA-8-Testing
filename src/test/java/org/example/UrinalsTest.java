package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    Urinals m = new Urinals();

    @Test
    void main() {
    }

    @Test
    void countUrinals() {
        assertEquals(1,m.COUNT_OPTIONS("10001"));
        assertEquals(0,m.COUNT_OPTIONS("1001"));
        assertEquals(3,m.COUNT_OPTIONS("00000"));
        assertEquals(2,m.COUNT_OPTIONS("0000"));
        assertEquals(1,m.COUNT_OPTIONS("01000"));
        assertEquals(-1,m.COUNT_OPTIONS("011"));
    }

    @Test
    void goodString() {
        assertEquals(true,m.goodString("1001"));
        assertEquals(false,m.goodString("1801"));
        assertEquals(true,m.goodString("00010"));

    }
}