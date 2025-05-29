public enum RANK {
    IRON_4(1), IRON_3(2), IRON_2(3), IRON_1(4),
    BRONZE_4(5), BRONZE_3(6), BRONZE_2(7), BRONZE_1(8),
    SILVER_4(9), SILVER_3(10), SILVER_2(11), SILVER_1(12),
    GOLD_4(13), GOLD_3(14), GOLD_2(15), GOLD_1(16),
    PLATINUM_4(17), PLATINUM_3(18), PLATINUM_2(19), PLATINUM_1(20),
    EMERALD_4(21), EMERALD_3(22), EMERALD_2(23), EMERALD_1(24),
    DIAMOND_4(25), DIAMOND_3(26), DIAMOND_2(27), DIAMOND_1(28),
    MASTER(30), GRANDMASTER(35), CHALLENGER(40);

    private final double points;

    RANK(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }
}
