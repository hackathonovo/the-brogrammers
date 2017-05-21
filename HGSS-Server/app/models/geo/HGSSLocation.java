package models.geo;

import com.avaje.ebean.Model;
import models.HGSSUser;

import javax.persistence.*;

/**
 * Created by penic on 20.05.17..
 */
@Entity
public class HGSSLocation extends Model{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public Double longitude;
    public Double latitude;

    public HGSSLocation(Double longitude, Double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
