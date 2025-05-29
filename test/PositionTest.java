import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testEnumValues() {
        // Ensure all constants are present
        assertEquals(5, POSITION.values().length, "POSITION should have exactly 5 constants.");
        assertArrayEquals(new POSITION[]{
                POSITION.TOP,
                POSITION.JNG,
                POSITION.MID,
                POSITION.BOT,
                POSITION.SUP
        }, POSITION.values(), "POSITION.values() should return all constants in order.");
    }

    @Test
    void testEnumValueOf() {
        // Test valid constants
        assertEquals(POSITION.TOP, POSITION.valueOf("TOP"));
        assertEquals(POSITION.JNG, POSITION.valueOf("JNG"));
        assertEquals(POSITION.MID, POSITION.valueOf("MID"));
        assertEquals(POSITION.BOT, POSITION.valueOf("BOT"));
        assertEquals(POSITION.SUP, POSITION.valueOf("SUP"));

        // Test invalid constant
        assertThrows(IllegalArgumentException.class, () -> POSITION.valueOf("INVALID"),
                "POSITION.valueOf() should throw IllegalArgumentException for invalid input.");
    }

    @Test
    void testEnumOrder() {
        // Verify the ordinal values
        assertEquals(0, POSITION.TOP.ordinal());
        assertEquals(1, POSITION.JNG.ordinal());
        assertEquals(2, POSITION.MID.ordinal());
        assertEquals(3, POSITION.BOT.ordinal());
        assertEquals(4, POSITION.SUP.ordinal());
    }

    @Test
    void testToString() {
        // Ensure the toString() method returns the enum constant name
        assertEquals("TOP", POSITION.TOP.toString());
        assertEquals("JNG", POSITION.JNG.toString());
        assertEquals("MID", POSITION.MID.toString());
        assertEquals("BOT", POSITION.BOT.toString());
        assertEquals("SUP", POSITION.SUP.toString());
    }
}