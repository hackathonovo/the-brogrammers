package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Hari on 20.5.2017..
 */
@Entity
public class HGSSChatMessage extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String username;

    public String message;

    public Date date;

    public HGSSChatMessage(String username, String message, Date date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public static Finder<Long, HGSSChatMessage> finder = new Finder<>(HGSSChatMessage.class);

    public static List<HGSSChatMessage> findAll() {
        return finder.all();
    }

    @Override
    public String toString() {
        return "{time=" + date.getTime() + ", user=" + username + ", message=" + message + "}";
    }


}
