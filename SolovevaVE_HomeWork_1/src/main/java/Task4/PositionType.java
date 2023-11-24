package Task4;

public enum PositionType {

    WORKER(1),
    MANAGER(3),
    SALER(2),
    HEAD(5);

    private int multiplier;

    PositionType(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
