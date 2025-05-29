import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    private Player p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    Team blue, red;

    @BeforeEach
    void setUp() {
        p1 = new Player("홍우", RANK.EMERALD_4, List.of(POSITION.TOP, POSITION.BOT));
        p2 = new Player("준원", RANK.DIAMOND_4, List.of(POSITION.JNG, POSITION.BOT));
        p3 = new Player("찬주", RANK.SILVER_2, List.of(POSITION.MID, POSITION.JNG));
        p4 = new Player("근해", RANK.BRONZE_2, List.of(POSITION.BOT, POSITION.SUP));
        p5 = new Player("경수", RANK.BRONZE_2, List.of(POSITION.SUP, POSITION.TOP));
        p2.setPartner(p4);
        p4.setPartner(p2);
        blue = new Team(p1, p2, p3, p4, p5);

        p6 = new Player("준오", RANK.PLATINUM_2, List.of(POSITION.TOP, POSITION.JNG));
        p7 = new Player("규민", RANK.GOLD_3, List.of(POSITION.JNG, POSITION.MID));
        p8 = new Player("혜원", RANK.SILVER_2, List.of(POSITION.MID, POSITION.SUP));
        p9 = new Player("현희", RANK.GOLD_3, List.of(POSITION.BOT, POSITION.MID));
        p10 = new Player("서영", RANK.BRONZE_4, List.of(POSITION.SUP, POSITION.MID));
        p6.setPartner(p9);
        p9.setPartner(p6);
        p7.setPartner(p10);
        p10.setPartner(p7);
        red = new Team(p6, p7, p8, p9, p10);
    }

    @Test
    void constructorTest() {
        Game game = new Game(blue, red);
        assertNotNull(game);
    }

    @Test
    void pointDifferenceTest() {
        Game game = new Game(blue, red);
        assertEquals(11, game.getPoint_difference());
    }

    @Test
    void toStringTest() {
        Game game = new Game(blue, red);
        assertEquals("TOP: 홍우 vs 준오\n" +
                "JNG: 준원 vs 규민\n" +
                "MID: 찬주 vs 혜원\n" +
                "BOT: 근해 vs 현희\n" +
                "SUP: 경수 vs 서영", game.toString());
    }

    @Test
    void validateTest() {
        Game game = new Game(blue, red);
        assertTrue(game.validate());
    }
}
