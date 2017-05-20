package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.QueryEachConsumer;
import models.geo.HGSSLocation;
import play.data.validation.Constraints;
import play.libs.F;

import javax.persistence.*;
import java.util.*;

/**
 * Created by penic on 20.05.17..
 */
@Entity
public class HGSSUser extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Constraints.Required
    @Column(unique=true)
    @Constraints.ValidateWith(value= HGSSUser.UsernameValidator.class, message = "Username must contain " +
            "at least 3 characters. All letters, numbers, points, dashes and underscores allowed.")
    public String username;

    @Constraints.Required
    public String password;

    public String firstName;
    public String lastName;

    public String role;
    public String skill;

    //living location
    public String location;

    //time available from
    public String availableFrom;

    //time available until
    public String availableUntil;

    public Boolean isAvailable;

    public Integer phoneNumber;

    @OneToMany (cascade = CascadeType.ALL)
    public List<HGSSLocation> currentLocations;

    @ManyToOne(fetch = FetchType.LAZY)
    public HGSSStation station;

    public HGSSUser(String username, String password, String firstName, String lastName,
                    String role, String skill, HGSSStation station){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.skill = skill;
        this.station = station;
    }

    @Override
    public String toString() {
        return "{Username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + "}";
    }

    public static Finder<Long, HGSSUser> finder = new Finder<>(HGSSUser.class);

    public static List<HGSSUser> findAll() {
        return finder.all();
    }

    public static HGSSUser checkUser(String username, String password) {
        return finder.where().eq("username", username).and().eq("password", password).findUnique();
    }

    public static HGSSUser findUserByUsername(String username) {
        return finder.where().eq("username", username).findUnique();
    }

    public static List<HGSSUser> findAvailableUsers(HGSSStation station){
        return finder.where().eq("station", station).eq("isAvailable", true).findList();
    }

    public static class UsernameValidator extends Constraints.Validator<String> {
        @Override
        public boolean isValid(String username) {
            String pattern="^[a-zA-Z0-9._-]{3,}$";
            return username != null && username.matches(pattern);
        }

        @Override
        public F.Tuple<String, Object[]> getErrorMessageKey() {
            return new F.Tuple<>("error.invalid.username", new Object[]{});
        }
    }

}
