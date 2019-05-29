package pl.atm.dietapp.dietapp.enums;

public enum Aim {
    LOSE(-250, "Chcę zrzucić wagę"),
    GAIN(250, "Chcę przytyć"),
    KEEP(0, "Chcę utrzymać wagę");

    private int kcal;
    private String aim;

    Aim(int kcal, String aim) {
        this.kcal = kcal;
        this.aim = aim;
    }

    public int getKcal() {
        return kcal;
    }

    public String getAim() {
        return aim;
    }

}
