import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private RANK rank;
    private List<POSITION> possible_positions;
    private Player partner; //Can be null

    public void setPartner(Player partner) {
        this.partner = partner;
    }

    public Player(String name, RANK rank, List<POSITION> possible_positions, Player partner) {
        this.name = name;
        this.rank = rank;
        this.possible_positions = possible_positions;
        this.partner = partner;
    }

    public Player(String name, RANK rank, List<POSITION> possible_positions) {
        this.name = name;
        this.rank = rank;
        this.possible_positions = possible_positions;
        this.partner = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public RANK getRank() {
        return rank;
    }

    public List<POSITION> getPossible_positions() {
        return possible_positions;
    }

    public Player getPartner() {
        return partner;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && rank == player.rank && Objects.equals(possible_positions, player.possible_positions) && Objects.equals(partner, player.partner);
    }
}
