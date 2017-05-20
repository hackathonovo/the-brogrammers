package controllers;


import models.HGSSStation;

import com.fasterxml.jackson.databind.JsonNode;

import models.HGSSUser;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
public class HGSSController extends Controller {

    private static final int UNKNOWN_USER_STATUS = 488;

    public Result getUsers(){
        List<HGSSUser> users = HGSSUser.findAll();

        return ok(views.html.users.render(users));
    }


    public Result getStations(){
        List<HGSSStation> stations = new ArrayList<>();
        stations.add(new HGSSStation("Bjelovar", 20.33, 21.33));
        stations.add(new HGSSStation("Delnice", 100.33, 91.33));
        stations.add(new HGSSStation("Čakovec", 180.33, 1.33));

        return ok(views.html.stations.render(stations));
    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result login(){
        // Get fields from the request
        JsonNode json = request().body().asJson();
        String username = json.findPath("username").textValue();
        String password = json.findPath("password").textValue();

        System.out.println(username);
        System.out.println(password);

        HGSSUser user = HGSSUser.checkUser(username, password);

        if(user == null){
            return status(UNKNOWN_USER_STATUS);
        }

        return ok(Json.toJson(user));

    }

}
