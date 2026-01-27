package code.kata.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class binSearchTests {
    @Test
    public void testChop() {

        assertEquals(-1, binSearch.chop(3, new int[]{}));
        assertEquals(-1, binSearch.chop(3, new int[]{1}));
        assertEquals(0, binSearch.chop(1, new int[]{1}));
        assertEquals(0, binSearch.chop(1, new int[]{1, 3, 5}));
        assertEquals(1, binSearch.chop(3, new int[]{1, 3, 5}));
        assertEquals(2, binSearch.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chop(6, new int[]{1, 3, 5}));

        assertEquals(0, binSearch.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, binSearch.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, binSearch.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, binSearch.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chop(8, new int[]{1, 3, 5, 7}));

    }

    @Test
    public void testChopRecursive() {

        assertEquals(-1, binSearch.chopRecursive(3, new int[]{}));
        assertEquals(-1, binSearch.chopRecursive(3, new int[]{1}));
        assertEquals(0, binSearch.chopRecursive(1, new int[]{1}));
        assertEquals(0, binSearch.chopRecursive(1, new int[]{1, 3, 5}));
        assertEquals(1, binSearch.chopRecursive(3, new int[]{1, 3, 5}));
        assertEquals(2, binSearch.chopRecursive(5, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chopRecursive(0, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chopRecursive(2, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chopRecursive(4, new int[]{1, 3, 5}));
        assertEquals(-1, binSearch.chopRecursive(6, new int[]{1, 3, 5}));

        assertEquals(0, binSearch.chopRecursive(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, binSearch.chopRecursive(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, binSearch.chopRecursive(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, binSearch.chopRecursive(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chopRecursive(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chopRecursive(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chopRecursive(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chopRecursive(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binSearch.chopRecursive(8, new int[]{1, 3, 5, 7}));

    }    
}
