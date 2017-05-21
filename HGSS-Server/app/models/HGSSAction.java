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

    public String title;

    public String description;

    public Double longitude;
    public Double latitude;

    @OneToMany(cascade = CascadeType.ALL)
    public List<HGSSChatMessage> messages;

    @ManyToOne
    public HGSSUser owner;

    @ManyToMany
    public List<HGSSUser> users;

    @OneToMany(cascade = CascadeType.ALL)
    public List<HGSSZone> zones;

    public Boolean isActive;

    public HGSSAction(HGSSUser owner, String title, Double longitude, Double latitude, String description){
        this.owner = owner;
        this.title = title;
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

    public static HGSSAction findById(Long id) {
        return finder.byId(id);
    }

    public static List<HGSSAction> findActiveActions(){
        return finder.where().eq("isActive", true).findList();
    }

}
