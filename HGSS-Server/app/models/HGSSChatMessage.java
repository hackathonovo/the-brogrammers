package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by Hari on 20.5.2017..
 */
@Entity
public class HGSSChatMessage extends Model{

    @ManyToOne
    public HGSSUser user;

    public String message;

    public Date date;

    public HGSSChatMessage(HGSSUser user, String message, Date date) {
        this.user = user;
        this.message = message;
        this.date = date;
    }

    public static Finder<Long, HGSSChatMessage> finder = new Finder<>(HGSSChatMessage.class);

    public static List<HGSSChatMessage> findAll() {
        return finder.all();
    }

    @Override
    public String toString() {
        return "{time=" + date.getTime() + ", user=" + user.username + ", message=" + message + "}";
    }


}
