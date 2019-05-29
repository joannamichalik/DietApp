package pl.atm.dietapp.dietapp.enums;

public enum Activity {
    NO_ACTIVITY(1.2),
    LOW_ACTIVITY(1.35),
    MID_ACTIVITY(1.55),
    HIGH_ACTIVITY(1.75),
    EXTREME_ACTIVITY(2.05);

    private double factor;

    Activity(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
