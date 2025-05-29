import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    @Test
    void constructorTest() {
        Player top = new Player("Hongwoo", RANK.EMERALD_4, List.of(POSITION.TOP, POSITION.BOT), null);
        assertNotNull(top);
        assertEquals("Hongwoo", top.getName());
        assertEquals(RANK.EMERALD_4, top.getRank());
        assertEquals(POSITION.TOP, top.getPossible_positions().get(0));
        assertEquals(POSITION.BOT, top.getPossible_positions().get(1));
        assertNull(top.getPartner());
    }

    @Test
    void toStringTest() {
        Player top = new Player("Hongwoo", RANK.EMERALD_4, List.of(POSITION.TOP, POSITION.BOT), null);
        assertEquals("Hongwoo", top.toString());
    }
}
