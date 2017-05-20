package models;

import com.avaje.ebean.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Hari on 20.5.2017..
 */
public class HGSSChatMessage extends Model{

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
