package models;

import com.avaje.ebean.Model;
import models.geo.HGSSZone;

import javax.persistence.*;
import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
@Entity
public class HGSSAction extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String description;

    public Double longitude;
    public Double latitude;

    @ManyToOne
    public HGSSUser owner;

    @OneToMany(cascade = CascadeType.ALL)
    public List<HGSSZone> zones;

    public HGSSAction(HGSSUser owner, Double longitude, Double latitude, String description){
        this.owner = owner;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{owner=" + owner.username + ", longitude=" + longitude + ", latitude=" + latitude + ", description="
                + description + "}";
    }

    public static Finder<Long, HGSSAction> finder = new Finder<>(HGSSAction.class);

}
