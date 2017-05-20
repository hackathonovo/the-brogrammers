package models;

import com.avaje.ebean.Model;
import models.geo.HGSSZone;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Boolean isActive;

    public HGSSAction(HGSSUser owner, Double longitude, Double latitude, String description){
        this.owner = owner;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "{owner=" + owner.username + ", longitude=" + longitude + ", latitude=" + latitude + ", description="
                + description + "}";
    }

    public static Finder<Long, HGSSAction> finder = new Finder<>(HGSSAction.class);

    public static List<HGSSAction> findAll() {
        return finder.all();
    }

    public static List<HGSSAction> findActiveActions(){
        return finder.where().eq("isActive", true).findList();
    }

}
