package models;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * Created by Hari on 20.5.2017..
 */
public class HGSSStation extends Model {


    public String stationName;

    public Double longitude;

    public Double latitude;

    public HGSSStation(String stationName, Double longitude, Double latitude) {
        this.stationName = stationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "StationName=" + stationName + ", longitude=" + longitude + ", latitude=" + latitude;
    }

    public static Finder<Long, HGSSStation> finder = new Finder<>(HGSSStation.class);

    public static List<HGSSStation> findAll() {
        return finder.all();
    }

}
