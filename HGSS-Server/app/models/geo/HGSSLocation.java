package models.geo;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
