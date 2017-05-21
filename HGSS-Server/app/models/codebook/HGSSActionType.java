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
public class HGSSActionType extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String actionType;

    public HGSSActionType(String role) {
        this.actionType = actionType;
    }

    public static Finder<Long, HGSSActionType> finder = new Finder<>(HGSSActionType.class);

    public static List<HGSSActionType> findAll(){
        return finder.all();
    }

    public static HGSSActionType findByType(String type) {
        return finder.where().eq("actionType", type).findUnique();
    }

    @Override
    public String toString() {
        return actionType;
    }
}
