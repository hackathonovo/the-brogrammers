package models;

import com.avaje.ebean.Model;
import models.enumerations.HGSSRole;
import models.enumerations.HGSSSkill;
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
    @Constraints.ValidateWith(value= BTUser.UsernameValidator.class, message = "Username must contain " +
            "at least 3 characters. All letters, numbers, points, dashes and underscores allowed.")
    public String username;

    @Constraints.Required
    public String password;

    public String firstName;
    public String lastName;

    @Column(unique = true)
    @Constraints.Email
    public String email;

    @Enumerated(EnumType.STRING)
    public HGSSRole role;

    @Enumerated(EnumType.STRING)
    public HGSSSkill skill;

    //@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    //@JoinColumn(name = "owner_id")
    //public java.util.List<BTTrip> trips = new ArrayList<>();

    @Override
    public String toString() {
        return "Username=" + username + ", firstName=" + firstName + ", lastName=" + lastName;
    }

    public static Finder<Long, HGSSUser> finder = new Finder<>(HGSSUser.class);

    public static List<HGSSUser> findAll() {
        return finder.all();
    }

    public static HGSSUser checkUser(String username, String password) {
        return finder.where().eq("username", username).and().eq("password", password).findUnique();
    }

    public static HGSSUser findUserByUsername(String username) {
        return null;
        //return finder.where().eq("username", username).findUnique();
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
