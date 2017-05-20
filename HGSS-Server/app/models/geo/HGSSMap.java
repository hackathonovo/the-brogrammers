package models.geo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by teo on 5/21/17.
 */
@Entity
public class HGSSMap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<HGSSZone> zone;

    public HGSSLocation base;

}
