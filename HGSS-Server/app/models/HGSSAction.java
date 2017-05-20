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

    @OneToMany(cascade = CascadeType.ALL)
    public List<HGSSZone> zones;

    public static Finder<Long, HGSSAction> finder = new Finder<>(HGSSAction.class);

}
