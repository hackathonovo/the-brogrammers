package models.geo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
@Entity
public class HGSSZone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<HGSSLocation> locations;

}
