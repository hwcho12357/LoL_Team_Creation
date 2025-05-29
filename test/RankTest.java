import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void testRankPoints() {
        // Verify points for a few key ranks
        assertEquals(1, RANK.IRON_4.getPoints());
        assertEquals(8, RANK.BRONZE_1.getPoints());
        assertEquals(12, RANK.SILVER_1.getPoints());
        assertEquals(16, RANK.GOLD_1.getPoints());
        assertEquals(30, RANK.MASTER.getPoints());
        assertEquals(35, RANK.GRANDMASTER.getPoints());
        assertEquals(40, RANK.CHALLENGER.getPoints());
    }

    @Test
    void testEnumValues() {
        // Ensure all constants are present
        assertEquals(31, RANK.values().length, "RANK should have 30 constants.");
        assertArrayEquals(new RANK[]{
                RANK.IRON_4, RANK.IRON_3, RANK.IRON_2, RANK.IRON_1,
                RANK.BRONZE_4, RANK.BRONZE_3, RANK.BRONZE_2, RANK.BRONZE_1,
                RANK.SILVER_4, RANK.SILVER_3, RANK.SILVER_2, RANK.SILVER_1,
                RANK.GOLD_4, RANK.GOLD_3, RANK.GOLD_2, RANK.GOLD_1,
                RANK.PLATINUM_4, RANK.PLATINUM_3, RANK.PLATINUM_2, RANK.PLATINUM_1,
                RANK.EMERALD_4, RANK.EMERALD_3, RANK.EMERALD_2, RANK.EMERALD_1,
                RANK.DIAMOND_4, RANK.DIAMOND_3, RANK.DIAMOND_2, RANK.DIAMOND_1,
                RANK.MASTER, RANK.GRANDMASTER, RANK.CHALLENGER
        }, RANK.values(), "RANK.values() should return all constants in order.");
    }

    @Test
    void testEnumValueOf() {
        // Test valid constants
        assertEquals(RANK.IRON_4, RANK.valueOf("IRON_4"));
        assertEquals(RANK.GOLD_1, RANK.valueOf("GOLD_1"));
        assertEquals(RANK.CHALLENGER, RANK.valueOf("CHALLENGER"));

        // Test invalid constant
        assertThrows(IllegalArgumentException.class, () -> RANK.valueOf("INVALID_RANK"),
                "RANK.valueOf() should throw IllegalArgumentException for invalid input.");
    }

    @Test
    void testEnumOrderAndOrdinal() {
        // Verify the order of constants using ordinal()
        assertEquals(0, RANK.IRON_4.ordinal());
        assertEquals(15, RANK.GOLD_1.ordinal());
        assertEquals(30, RANK.CHALLENGER.ordinal());
    }

    @Test
    void testRankPointsConsistency() {
        // Iterate over all ranks and verify point assignment
        int[] expectedPoints = {
                1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 30, 35, 40
        };

        RANK[] ranks = RANK.values();
        for (int i = 0; i < ranks.length; i++) {
            assertEquals(expectedPoints[i], ranks[i].getPoints(),
                    "Rank " + ranks[i] + " should have points " + expectedPoints[i]);
        }
    }
}
