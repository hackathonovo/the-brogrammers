package models.geo;

import javax.persistence.Entity;

/**
 * Created by penic on 20.05.17..
 */
@Entity
public class HGSSLocation {

    public Double longitude;
    public Double latitude;

    public HGSSLocation(Double longitude, Double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
