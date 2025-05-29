import java.util.HashSet;
import java.util.Set;

public class Game implements Comparable<Game>{
    private Team team1;
    private Team team2;
    private final int point_difference;
    private final int numberOfPreferredPositions;

    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        point_difference = calculateDifference(team1, team2);
        numberOfPreferredPositions = team1.getNumberOfPreferredPosition() + team2.getNumberOfPreferredPosition();
    }

    public int getNumberOfPreferredPositions() {
        return numberOfPreferredPositions;
    }

    public int getPoint_difference() {
        return point_difference;
    }

    private int calculateDifference(Team team1, Team team2) {
        return (int)Math.abs(team1.totalPoints - team2.totalPoints);
    }

    @Override
    public String toString() {
        return "TOP: " + team1.getTop() + " vs " + team2.getTop() + "\n"
                + "JNG: " + team1.getJng() + " vs " + team2.getJng() + "\n"
                + "MID: " + team1.getMid() + " vs " + team2.getMid() + "\n"
                + "BOT: " + team1.getBot() + " vs " + team2.getBot() + "\n"
                + "SUP: " + team1.getSup() + " vs " + team2.getSup();
    }

    public boolean validate() {
        return team1.validate() && team2.validate() && noSharedPlayers() && laneSimilarLevel();
    }

    public boolean laneSimilarLevel() {
        return Math.abs(team1.getTop().getRank().getPoints() - team2.getTop().getRank().getPoints()) <= 8
                && Math.abs(team1.getJng().getRank().getPoints() - team2.getJng().getRank().getPoints()) <= 8
                && Math.abs(team1.getMid().getRank().getPoints() - team2.getMid().getRank().getPoints()) <= 8
                && Math.abs(team1.getBot().getRank().getPoints() - team2.getBot().getRank().getPoints()) <= 8
                && Math.abs(team1.getSup().getRank().getPoints() - team2.getSup().getRank().getPoints()) <= 8;
    }

    private boolean noSharedPlayers() {
        Set<Player> players = new HashSet<>();
        players.add(team1.getTop());
        players.add(team1.getJng());
        players.add(team1.getMid());
        players.add(team1.getBot());
        players.add(team1.getSup());
        players.add(team2.getTop());
        players.add(team2.getJng());
        players.add(team2.getMid());
        players.add(team2.getBot());
        players.add(team2.getSup());
        return players.size() == 10;
    }

    @Override
    public int compareTo(Game otherGame) {
        return Integer.compare(this.point_difference, otherGame.point_difference);
    }
}
