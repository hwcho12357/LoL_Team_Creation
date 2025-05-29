import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<String, Player> players;
    private static HashMap<String, String> partners;

    public static void main(String[] args) {
        players = new HashMap<>();
        partners = new HashMap<>();

        // Read Players from the CSV File
        readPlayersFromCsv();
        linkPartners();
        List<Team> validTeams = generateValidTeams(new ArrayList<>(players.values()));
        List<Game> validGames = generateValidGames(validTeams);
        Collections.sort(validGames);
        for (Game game : validGames) {
            System.out.println(game);
            System.out.println("티어차이: " + game.getPoint_difference() + ", 메인 포지션: " + game.getNumberOfPreferredPositions());
        }
    }

    private static List<Team> generateValidTeams(List<Player> playerList) {
        List<Team> validTeams = new ArrayList<>();

        // Create all possible teams with 5 players
        for (int i = 0; i < playerList.size(); i++) {
            for (int j = 0; j < playerList.size(); j++) {
                if (i == j) continue;
                for (int k = 0 ; k < playerList.size(); k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < playerList.size(); l++) {
                        if (l == i || l == j || l == k) continue;
                        for (int m = 0; m < playerList.size(); m++) {
                            if (m == i || m == j || m == k || m == l) continue;

                            // Create a team using 5 players
                            Player top = playerList.get(i);
                            Player jng = playerList.get(j);
                            Player mid = playerList.get(k);
                            Player bot = playerList.get(l);
                            Player sup = playerList.get(m);

                            Team team = new Team(top, jng, mid, bot, sup);
                            if (team.validate()) {
                                validTeams.add(team);
                            }
                        }
                    }
                }
            }
        }

        return validTeams;
    }

    private static List<Game> generateValidGames(List<Team> validTeams) {
        List<Game> validGames = new ArrayList<>();

        // Pair every valid team with another valid team
        for (int i = 0; i < validTeams.size(); i++) {
            for (int j = i + 1; j < validTeams.size(); j++) {
                Team team1 = validTeams.get(i);
                Team team2 = validTeams.get(j);

                // Ensure no duplicate players between the two teams
                Game game = new Game(team1, team2);
                if (game.validate()) {
                    validGames.add(game);
                }
            }
        }

        return validGames;
    }

    private static void readPlayersFromCsv() {
        try {
            File file = new File("src/Members.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                RANK rank = RANK.valueOf(tokens[1]);
                List<POSITION> positions = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    if (tokens[i].charAt(0) == 'P') {
                        partners.put(name, tokens[i].substring(1));
                    } else {
                        positions.add(POSITION.valueOf(tokens[i]));
                    }
                }
                Player player = new Player(name, rank, positions);
                players.put(name, player);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void linkPartners() {
        // Link partners
        for (String name : partners.keySet()) {
            String partnerName = partners.get(name);
            if (partnerName != null && players.containsKey(partnerName)) {
                players.get(name).setPartner(players.get(partnerName));
            }
        }
    }
}