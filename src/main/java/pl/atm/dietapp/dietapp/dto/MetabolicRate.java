package pl.atm.dietapp.dietapp.dto;

import lombok.Data;
import pl.atm.dietapp.dietapp.enums.Activity;
import pl.atm.dietapp.dietapp.enums.Aim;
import pl.atm.dietapp.dietapp.enums.Gender;

@Data
public class MetabolicRate {

    private Gender gender;
    private double weight;
    private double height;
    private int age;
    private Activity activity;
    private Aim aim;

    public double calculateMetabolicRate() {
        if (height == 0) {
            return 0;
        }
        double result = 0;
        if (gender.name().equals(Gender.MALE.toString())) {
            result = 66 + 13.7 * weight + 5 * height - 6.76 * age;
        } else if (gender.name().equals(Gender.FEMALE.toString())) {
            result = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
        }
        Activity activityValue = Activity.valueOf(activity.name().toUpperCase());
        Aim aimValue = Aim.valueOf(aim.name().toUpperCase());
        result = result * activityValue.getFactor() + aimValue.getKcal();
        return Math.round(result);
    }
}
