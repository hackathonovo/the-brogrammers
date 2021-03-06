package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Hari on 20.5.2017..
 */

@Entity
public class HGSSStation extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String stationName;

    public Double longitude;

    public Double latitude;

    @OneToMany
    public HGSSUser users;

    public HGSSStation(String stationName, Double longitude, Double latitude) {
        this.stationName = stationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{name=" + stationName + ", longitude=" + longitude + ", latitude=" + latitude + "}";
    }

    public static Finder<Long, HGSSStation> finder = new Finder<>(HGSSStation.class);

    public static List<HGSSStation> findAll() {
        return finder.all();
    }

}
