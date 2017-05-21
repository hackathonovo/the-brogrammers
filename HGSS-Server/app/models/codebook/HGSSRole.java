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
public class HGSSRole extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String role;

    public HGSSRole(String role) {
        this.role = role;
    }

    public static Finder<Long, HGSSRole> finder = new Finder<>(HGSSRole.class);

    public static List<HGSSRole> findAll(){
        return finder.all();
    }

    public static HGSSRole findByRole(String role) {
        return finder.where().eq("role", role).findUnique();
    }

}
