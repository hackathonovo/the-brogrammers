package models.codebook;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by penic on 21.05.17..
 */
@Entity
public class HGSSSkill extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String skill;

    public HGSSSkill(String skill) {
        this.skill = skill;
    }

    public static Finder<Long, HGSSSkill> finder = new Finder<>(HGSSSkill.class);

    public static List<HGSSSkill> findAll(){
        return finder.all();
    }

    public static HGSSSkill findBySkill(String skill) {
        return finder.where().eq("skill", skill).findUnique();
    }

}
