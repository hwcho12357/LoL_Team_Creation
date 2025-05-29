import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {
    private Player top;
    private Player jng;
    private Player mid;
    private Player bot;
    private Player sup;
    double totalPoints;
    int numberOfPreferredPosition;

    public Team(Player top, Player jng, Player mid, Player bot, Player sup) {
        this.top = top;
        this.jng = jng;
        this.mid = mid;
        this.bot = bot;
        this.sup = sup;
        totalPoints = getTotalPoints();
        numberOfPreferredPosition = calculateNumberOfPreferredPositions();
    }

    public double getTotalPoints() {
        double topPoints = top.getPossible_positions().get(0).equals(POSITION.TOP) ? 1.0 : 0.8 * top.getRank().getPoints();
        double jngPoints = jng.getPossible_positions().get(0).equals(POSITION.JNG) ? 1.0 : 0.8 * jng.getRank().getPoints() * 1.4;
        double midPoints = mid.getPossible_positions().get(0).equals(POSITION.MID) ? 1.0 : 0.8 * mid.getRank().getPoints() * 1.3;
        double botPoints = bot.getPossible_positions().get(0).equals(POSITION.BOT) ? 1.0 : 0.8 * bot.getRank().getPoints() * 1.1;
        double supPoints = sup.getPossible_positions().get(0).equals(POSITION.SUP) ? 1.0 : 0.8 * sup.getRank().getPoints() * 1.2;
        return topPoints + jngPoints + midPoints + botPoints + supPoints;
    }


    public int calculateNumberOfPreferredPositions() {
        int number = 0;
        if (top.getPossible_positions().get(0) == POSITION.TOP) number++;
        if (jng.getPossible_positions().get(0) == POSITION.JNG) number++;
        if (mid.getPossible_positions().get(0) == POSITION.MID) number++;
        if (bot.getPossible_positions().get(0) == POSITION.BOT) number++;
        if (sup.getPossible_positions().get(0) == POSITION.SUP) number++;
        return number;
    }
    public int getNumberOfPreferredPosition() {
        return numberOfPreferredPosition;
    }

    public Player getTop() {
        return top;
    }

    public Player getJng() {
        return jng;
    }

    public Player getMid() {
        return mid;
    }

    public Player getBot() {
        return bot;
    }

    public Player getSup() {
        return sup;
    }

    @Override
    public String toString() {
        return "Team: " + top + " " + jng + " " + mid + " " + bot + " " + sup;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return totalPoints == team.totalPoints && Objects.equals(top, team.top) && Objects.equals(jng, team.jng) && Objects.equals(mid, team.mid) && Objects.equals(bot, team.bot) && Objects.equals(sup, team.sup);
    }

    public boolean validate() {
        return checkPartnersSameTeam() && checkPositions()
                && checkPartnersSymmetry() && checkForDuplicatePlayers();
    }

    public boolean checkForDuplicatePlayers() {
        Set<Player> players = new HashSet<>();
        players.add(top);
        players.add(jng);
        players.add(mid);
        players.add(bot);
        players.add(sup);
        return players.size() == 5;
    }

    public boolean checkPositions() {
        if (!top.getPossible_positions().contains(POSITION.TOP)) return false;
        if (!jng.getPossible_positions().contains(POSITION.JNG)) return false;
        if (!mid.getPossible_positions().contains(POSITION.MID)) return false;
        if (!bot.getPossible_positions().contains(POSITION.BOT)) return false;
        return sup.getPossible_positions().contains(POSITION.SUP);
    }

    public boolean checkPartnersSymmetry() {
        if (top.getPartner() != null) {
            if (top.getPartner().getPartner() == null) return false;
            if (!top.getPartner().getPartner().equals(top)) return false;
        }
        if (jng.getPartner() != null) {
            if (jng.getPartner().getPartner() == null) return false;
            if (!jng.getPartner().getPartner().equals(jng)) return false;
        }
        if (mid.getPartner() != null) {
            if (mid.getPartner().getPartner() == null) return false;
            if (!mid.getPartner().getPartner().equals(mid)) return false;
        }
        if (bot.getPartner() != null) {
            if (bot.getPartner().getPartner() == null) return false;
            if (!bot.getPartner().getPartner().equals(bot)) return false;
        }
        if (sup.getPartner() != null) {
            if (sup.getPartner().getPartner() == null) return false;
            if (!sup.getPartner().getPartner().equals(sup)) return false;
        }
        return true;
    }

    private boolean checkPartnersSameTeam() {
        // Check that each player's partner is in the same team
        if (top.getPartner() != null && !top.getPartner().equals(jng) && !top.getPartner().equals(mid) &&
                !top.getPartner().equals(bot) && !top.getPartner().equals(sup)) {
            return false;
        }
        if (jng.getPartner() != null && !jng.getPartner().equals(top) && !jng.getPartner().equals(mid) &&
                !jng.getPartner().equals(bot) && !jng.getPartner().equals(sup)) {
            return false;
        }
        if (mid.getPartner() != null && !mid.getPartner().equals(top) && !mid.getPartner().equals(jng) &&
                !mid.getPartner().equals(bot) && !mid.getPartner().equals(sup)) {
            return false;
        }
        if (bot.getPartner() != null && !bot.getPartner().equals(top) && !bot.getPartner().equals(jng) &&
                !bot.getPartner().equals(mid) && !bot.getPartner().equals(sup)) {
            return false;
        }
        if (sup.getPartner() != null && !sup.getPartner().equals(top) && !sup.getPartner().equals(jng) &&
                !sup.getPartner().equals(mid) && !sup.getPartner().equals(bot)) {
            return false;
        }
        return true;
    }

}
