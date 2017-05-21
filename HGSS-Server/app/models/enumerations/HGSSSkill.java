package models.enumerations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
public enum HGSSSkill {

    ALPINIZAM,
    PENJANJE,
    SPEOLOGIJA,
    SKIJANJE,
    MEDICINA;

    public static HGSSSkill toValue(String input) throws IllegalArgumentException{
        for (HGSSSkill skill : HGSSSkill.values()) {
            if (skill.toString().equals(input.toUpperCase())) {
                return skill;
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<String> getAllOptions() {
        List<String> list = new LinkedList<>();
        for (HGSSSkill skill : HGSSSkill.values()) {
            list.add(skill.toString().toLowerCase());
        }
        return list;
    }

}
